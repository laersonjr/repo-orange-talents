package com.laerson.zupdesafio.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> erros = criarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({DataIntegrityViolationException.class})
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest request) {
		String menssagemUsuario = messageSource.getMessage("recurso.em.duplicidade", null, LocaleContextHolder.getLocale());
		List<Erro> erros = Arrays.asList(new Erro(menssagemUsuario));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	private List<Erro> criarListaDeErros(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String menssagemUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			erros.add(new Erro(menssagemUsuario));
		}
		return erros;
	}

	public static class Erro {

		private String menssagemUsuario;

		public Erro(String menssagemUsuario) {
			super();
			this.menssagemUsuario = menssagemUsuario;
		}

		public String getMenssagemUsuario() {
			return menssagemUsuario;
		}

	}

}
