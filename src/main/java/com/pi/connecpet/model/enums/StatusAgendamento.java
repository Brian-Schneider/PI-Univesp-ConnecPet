package com.pi.connecpet.model.enums;

public enum StatusAgendamento {
    AGENDADO(1),
    CANCELADO(2),
    CONCLUIDO(3);

    private int valor;

    StatusAgendamento(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static StatusAgendamento fromValue(int valor) {
        for (StatusAgendamento status : StatusAgendamento.values()) {
            if (status.getValor() == valor) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor de Status inválido: " + valor);
    }
}
