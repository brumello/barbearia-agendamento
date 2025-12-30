package com.barbearia.exception;

public class HorarioOcupadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HorarioOcupadoException() {
		super("Já existe um agendamento para este horário");
	}
}
