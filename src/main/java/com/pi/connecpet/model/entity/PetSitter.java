package com.pi.connecpet.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_sitter")
public class PetSitter{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestador", referencedColumnName = "id")
    private Prestador prestador;

    @Column(name = "pets_hospedados")
    private int petsHospedados;

    @Column(name = "limite_pets_hospedados")
    private int limitePetsHospedados;

    @Column(name = "hospedagem")
    private boolean hospedagem;

    @Column(name = "descricao_locacao")
    private String descricaoLocacao;

    @Column(name = "descricao_rotina")
    private String descricaoRotina;

    @Column(name = "valor_diaria")
    private BigDecimal valorPorDiaria;

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

    public BigDecimal getValorPorDiaria() {
        return valorPorDiaria;
    }

    public void setValorPorDiaria(BigDecimal valorPorDiaria) {
        this.valorPorDiaria = valorPorDiaria;
    }
}
