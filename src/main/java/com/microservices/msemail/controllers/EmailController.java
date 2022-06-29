package com.microservices.msemail.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.msemail.dtos.EmailDto;
import com.microservices.msemail.entities.Email;
import com.microservices.msemail.services.EmailService;

@RestController()
@RequestMapping("email")
public class EmailController {
	
	@Autowired
	EmailService email_service;
	
	@PostMapping
	public Email enviando_email(@RequestBody @Valid EmailDto email_dto){
		Email email = new Email();
		BeanUtils.copyProperties(email_dto, email);
		return email_service.enviar(email);
	}
	
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> tratamentoParaValidacao(MethodArgumentNotValidException e){
		
		Map<String, String> erros = new HashMap<>();
		
		e.getBindingResult().getAllErrors().forEach((error) -> {
			String campo = ((FieldError) error).getField();
			String messagem = error.getDefaultMessage();
			
			erros.put(campo, messagem);
		});
		
		return erros;
	}
	
}
