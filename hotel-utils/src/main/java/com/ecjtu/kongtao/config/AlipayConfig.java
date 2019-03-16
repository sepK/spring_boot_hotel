package com.ecjtu.kongtao.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author t.k
 * @date 2019/3/14 16:02
 */
public class AlipayConfig {
    /** 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号*/
    public static String APP_ID = "";

    /** 商户私钥，您的PKCS8格式RSA2私钥*/
    public static String MERCHANT_PRIVATE_KEY = "";

    /** 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。*/
    public static String ALIPAY_PUBLIC_KEY = "";

    /** 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问*/
    public static String NOTIFY_URL = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    /** 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问*/
    public static String RETURN_URL = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    /** 签名方式*/
    public static String SIGN_TYPE = "RSA2";

    /** 字符编码格式*/
    public static String CHARSET = "utf-8";

    /** 支付宝网关*/
    public static String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";

    /** 日志地址*/
    public static String LOG_PAH = "";


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(LOG_PAH + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
