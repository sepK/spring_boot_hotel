package com.ecjtu.kongtao.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author t.k
 * @date 2019/3/14 16:02
 */
public class AlipayConfig {
    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String APP_ID = "2016092800614892";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String MERCHANT_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDtwD7LL+VWveyhqCANy3L43as7OAh1/u+Y9YBNLIkT6GLICFmKI4TRxENqROfHfDiqTbtaCcTwmreWxalZmIDjTC9iDId6RP2CVK0lKL1sSpQ4s6OMatjotcAkBIlC1ub9e6mYIkOK2BX0Q6wUSyJbpEsNsnfyVe4P6iR2zC0QKgCB8wq22rm8E3O+HS3ls/yRaPap5dDUSxYS2d1+28tI32J9aJ/WCB3htDC1fekkgahpedPvWXDTo7HjQ8i6sGvxecP3mcTXWRZTA6f2kceCcUdfT9AwwJIqpzw/kS5u42mOsfkI00d69OQnnifEGPQEYEo2WmWSL75pKBtJijRPAgMBAAECggEBAOjxt5S1dOssYzFw3RcnA5s69Y6sM/4IrxEbWX5D6HsM8dwz8ica7gPpXHQ+1ynpWEvkpXBuqftkXATp3ife+Em8V6ClzgfKmOidtpf19sKnv9peiBwIhEZd7chceXB3xxMNmvloeO0NE1WlCHFJvHw12SOufT9/WiVVsCyFmJF/8h4AVsREUWzJqlT8tY7TGyj2cfOudsnlAY3Ba8XF3prwN5QoiYQtjrNEmqDQ/A9C66ei/v9y/LsE9Re4RRHr/EVdHxzbPzuSDdn9x+7RQTO3pZ7/RXnJtanadT1m9LVAZenlKaKtPhp6zn/3Doxy8Z3X+AdzeyjI7GjiuJU57wECgYEA/jKXwnniJEe/ITnyAf/M29yz7EoxZV5sxTtF9iy4ASdcQXcOFamty+oR9Usu3Mh3Q+qE0Q7k3h1t3rXWX8iO93a4mBlgag9NMXOMXPeWBSMhCUgTi06uL1mvQagF4f6FL1r8rJ3NFbIZMm4yCrq6eQhXNe8egiWLo3PScMHWFu8CgYEA72/MnZ3u+hOhHIpcJqtTg0ZtE0OObHrH7ZuWrBy55hlaGlNUiXPpVsOd5yD4IfeLqiiwMEzvowB0HTetDU37cbMGz47UYHKIVxIJM7HfxZsQaqcPN2dMOoT+73ozV2z7nQR58esh4CsGfhedtw5vL0/hH8M1kBltqCnR/AU2uKECgYEAqstPkInYWkwira6DXriC6s8VzRPksJmLN9IlpcxSLeRGZm4Z9pA1iCdTvZ6wdAP1rppqdxUszdi0M8m1qlHVTYxlZzzVvS1eznU2wFhSYk1CKzxUdWt+Oa5mxRSiL0CWOEVINKsqWwN5Tpsf4HmqRRxHjKOHuiaD9mUh5kU3Fd0CgYAt5f2QXV0ZPTgOM4u0sfUBXje8kJ+1tdereb7pYVxVepimIUE8VCbvxfH4A37ta/mu9bvIlob9dTHNBAY9XayMwCfXE+csUehG4KM48KkXxUDhYQLuuPOI6EPCfmdnI/IbyGbj9BH7WeQVucs28yJnLGXYY+BZrjYyHUouiIVT4QKBgQDtf9cAreaaiRCRoV/GH/asyuFpyzkm0nMeG0QrkrbAWuy+xApRHS342AMiHtXkDYj/utmvzuIHGGRFk8j95hhWs+XwuWzAkXHFQPwOg+/zXkG9xidXVvzzb96QKRR0R1Uzf7chTuCvgE/UKT1MJoJwIIe8ATNKIYk0nBbyqWu0oA==";

    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvFGNll2+Q5KXVvTxEgBgow3gWUDcsOTx1DkGgKqN1sllLu2xtnThYmMp7dcaWvEeRlmg5qawB+TzUju82aXMlwnw3hNjFmFw+FNPMhr5wgWopXajPk363Tq6ZGufoHoCJrnN2zuL3twmoiEMOJ9zZi0GTUO/uNWjiykKQlLVfypsr+2Yh7S7Y8wfaJHwSIKnDmiqCsGFepVBLuO74UQj94IaNM3vIaj9FDW7fUpWhCnPI9kQm3YzGmY/9nc65lDcl/XoAnS2DDribmi/+5Rbm1CK2uEBlzbAf+QRY1pfdw0jJ6r9NEpyLm10IEuVGe/3B/uNo7kmE1R++swjG/ljswIDAQAB";

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String NOTIFY_URL = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String RETURN_URL = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    /**
     * 签名方式
     */
    public static String SIGN_TYPE = "RSA2";

    /**
     * 字符编码格式
     */
    public static String CHARSET = "utf-8";

    /**
     * 支付宝网关
     */
    public static String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 日志地址
     */
    public static String LOG_PAH = "";


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(LOG_PAH + "alipay_log_" + System.currentTimeMillis() + ".txt");
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
