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
		// ��ȡmailSender�ʼ�������
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		// �����ʼ�����ʵ�����
		Mail mail = new Mail();
		mail.setFrom("15116124714@163.com");
		mail.setTo("15116124714@163.com");
		mail.setSubject("�����Ǳ���(Html��������!");
		mail.setContent("�ʼ�����(������)");
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setFrom(mail.getFrom());
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			// ����META����������⣬true��ʾ��html������н���
			helper.setText("<html lang=\"en\">"+
							"<head><meta charset=\"UTF-8\"><title>��ʫ��</title></head><body>"+
							"<h1>����</h1><p>"+
							"<span style=\"color: red;\">���߲�������</span><br>"+
							"<b>����������</b><br>"+
							"<em>ҹ����������</em><br>"+
							"����֪���١�<br></p>"+
							"<img src='cid:Coupon'>"+//��ͼƬ����HTML�еĹؼ�
							"<p>�����Թ�˭��������ȡ�����պ��ࡣ</p>"+
							"</body></html>",true);
			
			//ͼƬǶ�뵽html�ļ���
			ClassPathResource resource = new ClassPathResource("/1.png");
			helper.addInline("Coupon", resource);
			
			//ͼƬ��Ϊ��������
			ClassPathResource imge = new ClassPathResource("/1.png");
			helper.addAttachment("Coupon.jpg", imge);
			
			//�����ʼ�
			mailSender.send(message);
			
			System.out.println("��������Html�ʼ����ͳɹ�");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
