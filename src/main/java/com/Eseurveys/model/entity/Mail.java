package com.Eseurveys.model.entity;

import lombok.Data;

@Data
public class Mail {

	private String email;
	private String subject;
	private String message;
	private String pathToAttachment;

}
