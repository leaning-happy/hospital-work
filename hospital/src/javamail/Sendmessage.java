package javamail;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class Sendmessage {
	// 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
	 // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）, 
	 // 对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
	 public static String myEmailAccount = "2512041822@qq.com";
	 public static String myEmailPassword = "qujfusuopywzdihc";
	 
	 // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
	 // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
	 public static String myEmailSMTPHost = "smtp.qq.com";
	 
	 // 收件人邮箱（替换为自己知道的有效邮箱）
	 public static String receiveMailAccount = "2587013709@qq.com";
	 
	 public static void sendeMail(String name ,int h) throws Exception {
	 // 1. 创建参数配置, 用于连接邮件服务器的参数配置
	 Properties props = new Properties();   // 参数配置
	 props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
	 props.setProperty("mail.smtp.host", myEmailSMTPHost); // 发件人的邮箱的 SMTP 服务器地址
	 props.setProperty("mail.smtp.auth", "true");  // 需要请求认证
	 
	 // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
	 // 如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
	 // 打开下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
	 /*
	 // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
	 //   需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
	 //   QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
	 final String smtpPort = "465";
	 props.setProperty("mail.smtp.port", smtpPort);
	 props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	 props.setProperty("mail.smtp.socketFactory.fallback", "false");
	 props.setProperty("mail.smtp.socketFactory.port", smtpPort);
	 */
	 
	 // 2. 根据配置创建会话对象, 用于和邮件服务器交互
	 Session session = Session.getDefaultInstance(props);
//	 session.setDebug(true);     // 设置为debug模式, 可以查看详细的发送 log
	 
	 // 3. 创建一封邮件
	 MimeMessage message = Createmessage(session, myEmailAccount, receiveMailAccount, name, h);
	 
	 // 4. 根据 Session 获取邮件传输对象
	 Transport transport = session.getTransport();
	 
	 // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
	 // 
	 // PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
	 //  仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
	 //  类型到对应邮件服务器的帮助网站上查看具体失败原因。
	 //
	 // PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
	 //  (1) 邮箱没有开启 SMTP 服务;
	 //  (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
	 //  (3) 邮箱服务器要求必须要使用 SSL 安全连接;
	 //  (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
	 //  (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
	 //
	 // PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
	 transport.connect(myEmailAccount, myEmailPassword);
	 
	 // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	 transport.sendMessage(message, message.getAllRecipients());
	 
	 // 7. 关闭连接
	 transport.close();
	 }
	 public static MimeMessage Createmessage(Session session, String sendMail, String receiveMail,String name ,int time) throws MessagingException, IOException {

//		 Session session= Session.getDefaultInstance(props); // 根据参数配置，创建会话对象（为了发送邮件准备的）
		 MimeMessage message = new MimeMessage(session); // 创建邮件对象
		 
		 /*
		  * 也可以根据已有的eml邮件文件创建 MimeMessage 对象
		  * MimeMessage message = new MimeMessage(session, new FileInputStream("MyEmail.eml"));
		  */
		 
		 // 2. From: 发件人
		 // 其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
		 // 真正要发送时, 邮箱必须是真实有效的邮箱。
		 message.setFrom(new InternetAddress(sendMail, "中南财经政法大学有间医院", "UTF-8"));
		 
		 // 3. To: 收件人
		 message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "USER_CC", "UTF-8"));
/*		 // To: 增加收件人（可选）
		 message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
		 // Cc: 抄送（可选）
		 message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
		 // Bcc: 密送（可选）
		 message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));   */
		 
		 // 4. Subject: 邮件主题
		 message.setSubject("病人挂号报告", "UTF-8");
		 
		 // 5. Content: 邮件正文（可以使用html标签）
		 message.setContent(name+"病人在今日"+time+"向您进行挂号", "text/html;charset=UTF-8");
		 
		 // 6. 设置显示的发件时间
		 message.setSentDate(new Date());
		 
		 // 7. 保存前面的设置
		 message.saveChanges();
		 
		 return message;
	 
		 
		 // 8. 将该邮件保存到本地
/*		 OutputStream out = new FileOutputStream("MyEmail.eml");
		 message.writeTo(out);
		 out.flush();
		 out.close(); */
		 }	 	
}



