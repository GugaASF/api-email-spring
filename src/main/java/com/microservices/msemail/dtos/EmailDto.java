package com.microservices.msemail.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import lombok.Data;

@Data
public class EmailDto {
	
	@NotBlank(message = "Remetente não informado.")
	@Email(message = "Email informado não é válido.")
	private String remetente;
	
	@NotBlank(message = "Destinatario não informado.")
	@Email(message = "Email informado não é válido.")
	private String destinatario;

	private String assunto;
	private String texto;
	
}
