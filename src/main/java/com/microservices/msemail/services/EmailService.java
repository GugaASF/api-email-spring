package com.microservices.msemail.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.microservices.msemail.entities.Email;
import com.microservices.msemail.enums.StatusMail;
import com.microservices.msemail.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository email_repository;
	@Autowired
	private JavaMailSender enviando;

	@SuppressWarnings("finally")
	public Email enviar(Email email) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getRemetente());
			message.setTo(email.getDestinatario());
			message.setSubject(email.getAssunto());
			message.setText(email.getTexto());
			email.setHora_envio(LocalDateTime.now());
			enviando.send(message);
			email.setStatus(StatusMail.SENT);
		} catch (MailException e) {
			email.setStatus(StatusMail.ERROR);
		} finally {
			return email_repository.save(email);
		}

	}

}
