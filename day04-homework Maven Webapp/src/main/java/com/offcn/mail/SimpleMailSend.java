package com.offcn.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SimpleMailSend {
	public static void main(String[] args) {
		//初始化spring环境
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mail.xml");
		//获取mailSender邮件发送类
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		//创建邮件发送实体对象
		Mail mail = new Mail();
		mail.setFrom("15116124714@163.com");
		mail.setTo("15116124714@163.com");
//		mail.setTo("wjjw0304@163.com");
		mail.setSubject("这是测试邮件");
		mail.setContent("邮件内容");
		
		//创建简单文本邮件对象
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
		message.setTo(mail.getTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		
		//发送邮件
		mailSender.send(message);
		
		System.out.println("简单文本邮件发送成功");
	}
}
