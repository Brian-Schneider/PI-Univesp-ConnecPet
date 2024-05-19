package com.pi.connecpet.dto;

import com.pi.connecpet.model.entity.Prestador;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class PetSitterDTO {

    private Long id;

    private Long prestadorId;

    private Prestador prestador;

    @NotNull(message = "O campo Hospedagem é obrigatório")
    private boolean hospedagem;


    private int petsHospedados;

    private int limitePetsHospedados;

    @Size(max = 1000, message = "O campo Descrição da Localação deve ter no máximo 1000 caracteres")
    private String descricaoLocacao;

    @Size(max = 1000, message = "O campo Descrição da Rotina deve ter no máximo 1000 caracteres")
    private String descricaoRotina;

    @NotNull(message = "O campo Valor por Diária é obrigatório")
    private BigDecimal valorPorDiaria;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public int getPetsHospedados() {
        return petsHospedados;
    }

    public void setPetsHospedados(int petsHospedados) {
        this.petsHospedados = petsHospedados;
    }

    public int getLimitePetsHospedados() {
        return limitePetsHospedados;
    }

    public void setLimitePetsHospedados(int limitePetsHospedados) {
        this.limitePetsHospedados = limitePetsHospedados;
    }

    public boolean isHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(boolean hospedagem) {
        this.hospedagem = hospedagem;
    }

    public String getDescricaoLocacao() {
        return descricaoLocacao;
    }

    public void setDescricaoLocacao(String descricaoLocacao) {
        this.descricaoLocacao = descricaoLocacao;
    }

    public String getDescricaoRotina() {
        return descricaoRotina;
    }

    public void setDescricaoRotina(String descricaoRotina) {
        this.descricaoRotina = descricaoRotina;
    }

    public Long getPrestadorId() {
        return prestadorId;
    }

    public void setPrestadorId(Long prestadorId) {
        this.prestadorId = prestadorId;
    }


    public @NotNull(message = "O campo Valor por Diária é obrigatório") BigDecimal getValorPorDiaria() {
        return valorPorDiaria;
    }

    public void setValorPorDiaria(@NotNull(message = "O campo Valor por Diária é obrigatório") BigDecimal valorPorDiaria) {
        this.valorPorDiaria = valorPorDiaria;
    }
}
