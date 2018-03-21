package com.offcn.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.offcn.mail.Mail;

public class SendMailWithAttachment {
	public static void main(String[] args) {
		//初始化spring环境
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mail.xml");
		//获取mailSender邮件发送类
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		//创建邮件发送实体对象
		Mail mail = new Mail();
		mail.setFrom("15116124714@163.com");
		mail.setTo("15116124714@163.com");
		mail.setSubject("这是测试邮件-带附件");
		mail.setContent("邮件内容(带附件)");
		//创建带附件内容对象
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message,true);
			helper.setFrom(mail.getFrom());
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getContent());
			
			//添加两个附件(附件位置位于java-->resource目录)
			ClassPathResource image = new ClassPathResource("/1.png");
			helper.addAttachment("1.png", image);
			
			//发送邮件
			mailSender.send(message);
			
			System.out.println("带附件邮件发送成功");
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
