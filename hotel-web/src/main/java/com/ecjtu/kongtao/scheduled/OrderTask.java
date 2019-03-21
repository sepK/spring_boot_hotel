package com.ecjtu.kongtao.scheduled;

import com.ecjtu.kongtao.bean.housing.Housing;
import com.ecjtu.kongtao.bean.order.OrderInfo;
import com.ecjtu.kongtao.bean.order.OrderStatus;
import com.ecjtu.kongtao.service.BaseService;
import com.ecjtu.kongtao.service.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author t.k
 * @date 2019/3/20 17:55
 */
@Service
public class OrderTask extends BaseService {

    @Autowired
    private HousingService housingService;

    @Scheduled(cron = "0 0/10 * * * ?")
    public void checkOrder() {
        List<OrderInfo> orderInfos = orderInfoMapper.selectByExample(null);
        Date now = new Date();
        orderInfos.forEach(orderInfo -> {
            if (orderInfo.getOrderStatus() == OrderStatus.BOOKED.getStatus() && orderInfo.getCreateTime().getTime() > now.getTime() - 10 * 60 * 1000) {
                orderInfo.setOrderStatus(OrderStatus.CANCEL_ORDER.getStatus());
            } else if (orderInfo.getOrderStatus() == OrderStatus.CHECK_IN.getStatus()) {
                Housing housing = housingService.getHousing(orderInfo.getHousingId());
                if (housing.getEndTime().getTime() >= now.getTime()) {
                    orderInfo.setOrderStatus(OrderStatus.FINISH.getStatus());
                }
            }
            orderInfoMapper.updateByPrimaryKey(orderInfo);
        });

        System.out.println(now.getTime());
    }
}
