package com.pi.connecpet.model.enums;

public enum TipoServico {
    PET_SITTER(1),
    PET_WALKER(2);

    private int valor;

    TipoServico(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoServico servico(int valor) {
        for (TipoServico servico : TipoServico.values()) {
            if (servico.getValor() == valor) {
                return servico;
            }
        }
        throw new IllegalArgumentException("Valor de TipoServico inválido: " + valor);
    }
}
