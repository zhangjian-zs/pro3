package com.mynb.config;


import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000116662610";

	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDQVqJ0OORiSvWHtBiecIcoKh5b+LL3RPRv03yH3e40+qDJtu5gfXmO7z0gHIIomTVm17xAultrKhFFcbnnyvqlJ+Dkj95BQo/fbbbhhqnNGQ4CJESAVoiQsXGO2vko8uREtxXUicPU+8MqCP+xUpw/50IJPcPBFBuq6FTtXWjHlJANZD23/FuXeWpg8z3qSWk6kQXHzluxq+D8RPdY8HlUm+MbrvVdVKGxAYBv4ytPkKGF90ksawWOmz8yFJLeTeuWCbiUFkFFYR4ym03xX8grnAFsp/+1WgjY2t4N+Cjh7HQL76BUtUhnBwRLL4Cd8bBtNPOZjPUb1Khrt+nf7OoVAgMBAAECggEABxbLlFTTQJz4WdPA+rMthipYuhxuSoeoIZ36oMzmbBsTGYoF9naOilSNqegObb841/UDTNiKf80ApXJHNyHrAW+n8V8L2wCe0KV1EZt5b6comN4PDqbjIrlG+ettiv0o00W/kmnVpgujCm0f9jKvamU+E/5sCMfcYSZirWj+Rbwyqw/QDLpVaJOOzY17teBllyLvlm7+wWbcJESL5I+cRN9BWcOJUf52exnEk6GdZqZz0/IiSqwXNUCMRLDpix7hNgVKNmOdGLGNyfo0sC53QW5x803ffaT7K9gd2xhMPioJqdMKgnYsr72p6Z1yUiFT8zlGAKCKSPsC2cdN0pRgiQKBgQDorJhhnW8y3CMluCYXUN0Jua0+8BF5TrWvaecAOcrJOr3FjsGvK2AA6j6lnL7uvOq0wjC78w/RvNA9Nsmbvq2WZxoIaV6Kk5F+9o5QNFdLI4ITWdN9DGVAlITgK7aTbkv8Q34ud3jKDxvwtdP2vLtxWst77BMn2mG8M7SMHH4EBwKBgQDlOXrqDAr2WH/lep6glqfmVIRpPWHT4F2QfsW5dnNtAOVv285iQoLsXR5FbS3C2zep6A5jWE7RZekj0dR3dtMJFWTBbGb0a7WfSdO+yNb1z6epc/g8dXjvqatvn+KbXj39p0zmjmf8LAZwMY6EMDu/Wl1jQUYJsc1nMRuFCaqyAwKBgQC0iO83lrOob/zpkIglwT2xBRwy4I1+ZZ89u1tc5nq9RtHmz0zjgTFdpGP1lrjjfzxSAvdTblaQ9ANT7AXkzb/dGqStcCzGM5hKPj7QZrxw9d1A7IrX1V1fDZ5IXkKtBID6/NeUcGkNx0lzrXIJWgnK+5s1zUhTvPPm1uu5Z4Yz0wKBgGYsRNlmHMzJjdif220BOj20loDCV4S1kX8Cwud0IOcJazt84nVx6CGrL/8KN0ePpzQYt7EYf6len5jTwrytPkviOVLuGsX/7Kjfo356zzYqJTWm95MbWZiaLExJHBzc2QzjMafi+f6xMP15WWkahsc4ZEAFrE5N7px8iyO1t1w5AoGAPCkbhI7X+oPTKpOYAcBV29fZA1NHWUiGV+s89p8yWbIJgqTs6jxmwKUvVyv3ABdMXypEZ1tMIQqwpzfooj6QBX2UKa2aHufl6W6LMQRgBTxSmYnO2r1UarqpUOaGgd6Y8RayPjXnIYKFl4+DbBteaBb16XpgvDbD05kdme7DD78=";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiRtcvnfChinl+gyJw3MqFHecPbVvKkk8YOdWyY+kD48IfeMCkV89yGmyzmKcfD/f6PpV/xc6LVnESFfbBdp0/IKlrv3mwLFO5XUuQHx4eRTse1zF5Tndsuvui+nK/+TlGvFlZ9kpO8cbU283wGf83lpHMO2WwuaS+ci/t2nz4Smik+zuyfO3i5R6YqSpqxCe/6dVMfGSxmFyNTqiDpCt6bubw0OwbozljHOQLB8dpMaT2I8DGNlgfG4Ov1B84tgxEs7boPwIvF0fiXEj4Z2IlyhlAed++v64TbDrGnCstnodrX72v6qe5c8CgYxfHW6dSOcMfSuxaRTLbbnzTITHWQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/studentMain/shoppingCart";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关，沙箱使用alipaydev，真实使用时使用alipay
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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

