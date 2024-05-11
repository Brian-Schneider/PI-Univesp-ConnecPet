package com.pi.connecpet.model.enums;

public enum Sexo {
    MACHO(1),
    FEMEA(2);

    private int valor;

    Sexo(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static Sexo fromValue(int valor) {
        for (Sexo sexo : Sexo.values()) {
            if (sexo.getValor() == valor) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Valor de Sexo inválido: " + valor);
    }
}
