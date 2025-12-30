package com.barbearia.entity;

public enum TipoServico {
    CORTE(35.00),
    BARBA(15.00);

    private final double valor;

    TipoServico(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}