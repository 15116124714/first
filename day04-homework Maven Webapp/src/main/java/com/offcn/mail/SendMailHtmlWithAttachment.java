package com.offcn.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMailHtmlWithAttachment {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mail.xml");
		// 获取mailSender邮件发送类
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		// 创建邮件发送实体对象
		Mail mail = new Mail();
		mail.setFrom("15116124714@163.com");
		mail.setTo("15116124714@163.com");
		mail.setSubject("这里是标题(Html带附件）!");
		mail.setContent("邮件内容(带附件)");
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setFrom(mail.getFrom());
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			// 设置META解决乱码问题，true表示对html代码进行解析
			helper.setText("<html lang=\"en\">"+
							"<head><meta charset=\"UTF-8\"><title>古诗词</title></head><body>"+
							"<h1>春晓</h1><p>"+
							"<span style=\"color: red;\">春眠不觉晓，</span><br>"+
							"<b>处处闻啼鸟。</b><br>"+
							"<em>夜来风雨声，</em><br>"+
							"花落知多少。<br></p>"+
							"<img src='cid:Coupon'>"+//将图片插入HTML中的关键
							"<p>人生自古谁无死，留取丹心照汗青。</p>"+
							"</body></html>",true);
			
			//图片嵌入到html文件中
			ClassPathResource resource = new ClassPathResource("/1.png");
			helper.addInline("Coupon", resource);
			
			//图片作为附件发送
			ClassPathResource imge = new ClassPathResource("/1.png");
			helper.addAttachment("Coupon.jpg", imge);
			
			//发送邮件
			mailSender.send(message);
			
			System.out.println("带附件的Html邮件发送成功");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
