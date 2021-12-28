package com.Eseurveys.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.Mail;
import com.Eseurveys.service.MailService;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	private Environment environment;

	@Override
	public void sendSimpleMessage(Mail mail) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getSubject());
			mimeMessageHelper.setFrom(new InternetAddress(environment.getProperty("spring.mail.username")));
			mimeMessageHelper.setTo(new InternetAddress(mail.getEmail()));
			mimeMessageHelper.setText(mail.getMessage());
			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendMessageWithAttachment(Mail mail) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getSubject());
			mimeMessageHelper.setFrom(new InternetAddress(environment.getProperty("spring.mail.username")));
			mimeMessageHelper.setTo(new InternetAddress(mail.getEmail()));
			mimeMessageHelper.setText(mail.getMessage());
			FileSystemResource file = new FileSystemResource(new File(mail.getPathToAttachment()));
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
