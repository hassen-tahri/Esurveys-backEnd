package com.Eseurveys.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Eseurveys.model.entity.Mail;
import com.Eseurveys.service.MailService;

@CrossOrigin("*")
@RestController
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MailController {

	@Autowired
	private MailService mailService;

	@PostMapping("/email")
	public ResponseEntity<Mail> enviarEmail(@RequestBody Mail mail) {
		try {
			if (mail.getPathToAttachment() == null) {
				mailService.sendSimpleMessage(mail);
			} else {
				mailService.sendMessageWithAttachment(mail);
			}
			return new ResponseEntity<>(mail, HttpStatus.OK);
		} catch (MailException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
