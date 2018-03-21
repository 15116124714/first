package com.offcn.mail;

public class Mail {
	/** 发件人 **/
	private String from;
	/** 收件人 **/
	private String to;
	/** 主题 **/
	private String subject;
	/** 邮件内容 **/
	private String content;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Mail [from=" + from + ", to=" + to + ", subject=" + subject + ", content=" + content + "]";
	}
	
	
}
