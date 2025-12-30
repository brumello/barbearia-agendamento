package com.barbearia.exception;

public class AgendaNaoDefinidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AgendaNaoDefinidaException() {
		super("A agenda do barbeiro ainda não foi definida");
	}
}