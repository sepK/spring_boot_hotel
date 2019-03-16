package com.ecjtu.kongtao.manager;

import com.ecjtu.kongtao.bean.employee.EmployeeType;
import com.ecjtu.kongtao.bean.room.RoomStatus;
import com.ecjtu.kongtao.bean.room.RoomType;
import com.ecjtu.kongtao.utils.RedisUtils;
import com.ecjtu.kongtao.utils.SessionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author t.k
 * @date 2019/2/22 15:13
 */
public class SessionManager {

    @Autowired
    private RedisUtils redisUtils;
    /**
     * 给页面一些常用的固定数据添加session 如 房间类型 员工职位
     * @param request
     */
    public static void setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (ObjectUtils.isEmpty(session.getAttribute(SessionKey.ROOM_NUMBER))) {
            List<RoomType> roomTypes = Stream.of(RoomType.values()).collect(Collectors.toList());
            session.setAttribute(SessionKey.ROOM_NUMBER, roomTypes);
        }
        if (ObjectUtils.isEmpty(session.getAttribute(SessionKey.ROOM_STATUS))) {
            List<RoomStatus> roomStatuses = Stream.of(RoomStatus.values()).collect(Collectors.toList());
            session.setAttribute(SessionKey.ROOM_STATUS, roomStatuses);
        }
        if (ObjectUtils.isEmpty(session.getAttribute(SessionKey.EMPLOYEE_TYPE))) {
            List<EmployeeType> employeeTypes = Stream.of(EmployeeType.values()).collect(Collectors.toList());
            session.setAttribute(SessionKey.EMPLOYEE_TYPE, employeeTypes);
        }
    }
}
