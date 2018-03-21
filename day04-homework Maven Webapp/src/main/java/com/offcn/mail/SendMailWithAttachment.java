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
		//��ʼ��spring����
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mail.xml");
		//��ȡmailSender�ʼ�������
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		//�����ʼ�����ʵ�����
		Mail mail = new Mail();
		mail.setFrom("15116124714@163.com");
		mail.setTo("15116124714@163.com");
		mail.setSubject("���ǲ����ʼ�-������");
		mail.setContent("�ʼ�����(������)");
		//�������������ݶ���
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message,true);
			helper.setFrom(mail.getFrom());
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getContent());
			
			//�����������(����λ��λ��java-->resourceĿ¼)
			ClassPathResource image = new ClassPathResource("/1.png");
			helper.addAttachment("1.png", image);
			
			//�����ʼ�
			mailSender.send(message);
			
			System.out.println("�������ʼ����ͳɹ�");
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
