package alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016093000630986";
	// 私钥 pkcs8格式的
	public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCsKFR7Pfin+pFu54hOvIIxrVJtE7OKhvZHxjmmlqLAX81a8GFKkJ2F3YhpNREqegH6E/j2UpyEkpu9k2efGNShDmH0lDGT/+C+dbOCmhp5JBF90hFHNhC3/EVW7wcqd2YOC4l0Z3ViqWcAASf+bT1ZjjyVoNLIHQpO+FWl6CKvfSg3NYFX3aYDW0CZzkpH5X+R7wmrhbptbX75mIb7axwNNCU3ZKhfFuE6XUyFiQfgN1vH5AzWXbWPbjP5DKo6th3uvICRb6YxwuFFTnxI2jzvVRdfeYUA8XB+WFmHT6OaOY4+5EAL23Bqj8qiIGJw1v4raUq9zA21ouWIw2UsjgFJAgMBAAECggEAMMPryk0vlkV/1K55CfST3IaABq3B+cdpE8OuqOWajGuWu9/Db1+vfy/VaBfEGQgebzwhFYUpGNR+kSCkBYj/EfAFB0bDFG0yuECW7LPCM/ZnjgBnLIjAC53F9m4W1Yykt+3Erdhwg9YAexvYvFUtP6TuvGOl0VGIjf4CJNCwooyV2JiEkSOJH8zdvkcIUvv8mWKFnVeb9NLBjXM+XJM95BESY0ggDuIh8eu0UiFP12CFLiHF+4YHr3JVMl/1Cz5RdPqftUgCQj08E0oHN6I4cioN/Bb5IQTanFmBLA8ZEoasrO/xet4kqQk1oAt1Dz3adTnyq6Ek2AMvrlW40jHNEQKBgQDma4vNkhPlWWUHmxrY72z/8bi5sA7Q6Uyu11wxLugEKs8Y8SM14mVNUwCWuHMQp/4i6t3q8Kj4nocE7BN0zMtfMZgt0laTaIZ04w8N7B0AaQT3uK9/rNqtNZ/ShCGcsUq4E2uZTvBmc4baTcYC5cv8UwpkjKfAWCed4q5tLlDv2wKBgQC/RPvD20yeCEJEiQhoxJS/GMABxDtgRVFujUqRtKkeu9oQknPtnnoTKIoFbXhYSur/Lx4D7V+GpIh23CP3VGLuIaSsG5sl83DZX65vRu5UBIp7PltoOz1FHYdNn7i9eAXZfBuBy/ttmKElJ+8SHZ6X5P8ydQwGaavviVLs9lB+qwKBgFGkZ4u2J5CLBS4VugSFiRSC3FYG2KkTENWefw76NMFNPcXzouszxXsJXtsIjdSoAXbzyx+0l9pHqUWINDidW63mD6qkrYJbddCypyHiuD/t9hGkAaL2ZyEaL//SS2qOsw/X6bcPbkSOyIhPKErci1NjRPptj/6p/ZeGuxD6aTkjAoGAKuMl7MG0iU7ixQlQ+GTz0XGURBEjGzAP1VEbIla3ASwv9j1QfzxktP0HDbaBIJMT5EpFWa4VGFS2QKiV6/RhBnJGwUyjWjwe1q7spwjpka8++el+h32Y/HFlkFM7EkjiTuTUKiN56hYqM/GjWpWHpRl023SBUMLLCbfp/zYv0GcCgYAcnuPgctg5Yz5c0K3SbdzQBCn/dE6bkdHjltVYfN9AoUlHk2p9pPPe1LL72B1BLLT4Ac4hcObvKUnvfo7LsywTH+/Ib7erYtWq4VV/fDyRPq+cQoIDfaO2rw4E7JI2nsG9nYb/vm24RZE6L5LrXNOCDdvpKZyhS1R3vQB03WjiUQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjrEVFMOSiNJXaRNKicQuQdsREraftDA9Tua3WNZwcpeXeh8Wrt+V9JilLqSa7N7sVqwpvv8zWChgXhX/A96hEg97Oxe6GKUmzaZRNh0cZZ88vpkn5tlgL4mH/dhSr3Ip00kvM4rHq9PwuT4k7z1DpZAf1eghK8Q5BgxL88d0X07m9X96Ijd0yMkXArzD7jg+noqfbztEKoH3kPMRJC2w4ByVdweWUT2PwrlATpZZtYLmtDvUKG/sOkNAIKEMg3Rut1oKWpjyYanzDgS7Cg3awr1KPTl9rHCazk15aNYowmYtVabKwbGVToCAGK+qQ1gT3ELhkGnf3+h53fukNqRH+wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
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

