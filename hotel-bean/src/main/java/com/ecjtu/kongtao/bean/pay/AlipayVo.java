package com.ecjtu.kongtao.bean.pay;

import java.io.Serializable;

/**
 * @author t.k
 * @date 2019/3/14 16:50
 */
public class AlipayVo implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 订单名称
     */
    private String subject;
    /**
     * 商户网站唯一订单号
     */
    private String outTradeNo;
    /**
     * 该笔订单允许的最晚付款时间
     */
    private String timeoutExpress;
    /**
     * 付款金额
     */
    private String totalAmount;
    /**
     * 销售产品码，与支付宝签约的产品码名称
     */
    private String productCode;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
