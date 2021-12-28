package com.Eseurveys.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailDto {
	private String email;
	private String subject;
	private String message;
	private String pathToAttachment;

}
