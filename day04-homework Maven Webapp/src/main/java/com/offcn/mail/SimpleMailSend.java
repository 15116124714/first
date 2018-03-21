package com.offcn.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SimpleMailSend {
	public static void main(String[] args) {
		//��ʼ��spring����
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mail.xml");
		//��ȡmailSender�ʼ�������
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		//�����ʼ�����ʵ�����
		Mail mail = new Mail();
		mail.setFrom("15116124714@163.com");
		mail.setTo("15116124714@163.com");
//		mail.setTo("wjjw0304@163.com");
		mail.setSubject("���ǲ����ʼ�");
		mail.setContent("�ʼ�����");
		
		//�������ı��ʼ�����
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
		message.setTo(mail.getTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		
		//�����ʼ�
		mailSender.send(message);
		
		System.out.println("���ı��ʼ����ͳɹ�");
	}
}
