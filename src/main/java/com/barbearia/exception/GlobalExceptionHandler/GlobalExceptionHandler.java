package com.barbearia.exception.GlobalExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.barbearia.exception.AgendaFechadaException;
import com.barbearia.exception.AgendaNaoDefinidaException;
import com.barbearia.exception.HorarioOcupadoException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HorarioOcupadoException.class)
	public ResponseEntity<Map<String, Object>> horarioOcupado(HorarioOcupadoException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("timestamp", LocalDateTime.now(), "status",
				400, "erro", "HORARIO_OCUPADO", "mensagem", ex.getMessage()));
	}

	@ExceptionHandler(AgendaFechadaException.class)
	public ResponseEntity<Map<String, Object>> agendaFechada(AgendaFechadaException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("timestamp", LocalDateTime.now(), "status",
				400, "erro", "AGENDA_FECHADA", "mensagem", ex.getMessage()));
	}

	@ExceptionHandler(AgendaNaoDefinidaException.class)
	public ResponseEntity<Map<String, Object>> agendaNaoDefinida(AgendaNaoDefinidaException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("timestamp", LocalDateTime.now(), "status",
				400, "erro", "AGENDA_NAO_DEFINIDA", "mensagem", ex.getMessage()));
	}
}