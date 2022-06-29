package com.microservices.msemail.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.microservices.msemail.enums.StatusMail;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_email")
public class Email {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String remetente;
	private String destinatario;
	private String assunto;
	@Column(columnDefinition = "text")
	private String texto;
	private StatusMail status;
	private LocalDateTime hora_envio;
	
	
	
}
