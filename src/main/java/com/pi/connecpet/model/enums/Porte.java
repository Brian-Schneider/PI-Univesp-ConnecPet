package com.pi.connecpet.model.enums;

public enum Porte {
    MINI(1),
    PEQUENO(2),
    MÉDIO(3),
    GRANDE(4),
    GIGANTE(5);

    private int valor;

    Porte(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static Porte fromValue(int valor) {
        for (Porte porte : Porte.values()) {
            if (porte.getValor() == valor) {
                return porte;
            }
        }
        throw new IllegalArgumentException("Valor de Porte inválido: " + valor);
    }
}
