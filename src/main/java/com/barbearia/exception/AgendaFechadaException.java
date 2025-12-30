package com.barbearia.exception;

public class AgendaFechadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AgendaFechadaException() {
		super("A agenda está fechada no momento");
	}
}