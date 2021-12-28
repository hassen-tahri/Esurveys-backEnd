package com.Eseurveys.service;

import com.Eseurveys.model.entity.Mail;

public interface MailService {
	public void sendSimpleMessage(Mail mail);

	public void sendMessageWithAttachment(Mail mail);
}
