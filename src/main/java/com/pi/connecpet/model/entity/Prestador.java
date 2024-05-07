package com.pi.connecpet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pi.connecpet.model.enums.Porte;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_prestador")
public class Prestador extends Pessoa {

    @Column(name = "cpf")
    @NotNull(message = "O campo CPF é obrigatório")
    @Size(max = 14, message = "O campo CPF deve ter no máximo 11 caracteres")
    private String cpf;

    @Column(name = "pet_sitter")
    private boolean petSitter;

    @Column(name = "pets_hospedados")
    private int petsHospedados;

    @Column(name = "limite_pets_hospedados")
    private int limitePetsHospedados;

    @Column(name = "hospedagem")
    private boolean hospedagem;

    @Column(name = "descricao_locacao")
    @Size(max = 1000, message = "O campo Descrição da Localação deve ter no máximo 1000 caracteres")
    private String descricaoLocacao;

    @Column(name = "descricao_rotina")
    @Size(max = 1000, message = "O campo Descrição da Rotina deve ter no máximo 1000 caracteres")
    private String descricaoRotina;

    @Column(name = "valor_hora_hospedada")
    @NotNull(message = "O campo Valor da Hora Hospedada é obrigatório")
    private double valorHoraHospedada;

    @Column(name = "pet_walker")
    private boolean petWalker;

    @Column(name = "tempo_passeio")
    @NotNull(message = "O campo Tempo de Passeio é obrigatório")
    private double tempoPasseio;

    @Column(name = "portes_aceitos")
    @NotNull(message = "O campo Portes Aceitos é obrigatório")
    private List<Porte> portesAceitos;

    @Column(name = "valor_hora_passeio")
    private double valorHoraPasseio;

    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("prestador")
    private List<Agendamento> agendamentos;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isPetSitter() {
        return petSitter;
    }

    public void setPetSitter(boolean petSitter) {
        this.petSitter = petSitter;
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

    public double getValorHoraHospedada() {
        return valorHoraHospedada;
    }

    public void setValorHoraHospedada(double valorHoraHospedada) {
        this.valorHoraHospedada = valorHoraHospedada;
    }

    public boolean isPetWalker() {
        return petWalker;
    }

    public void setPetWalker(boolean petWalker) {
        this.petWalker = petWalker;
    }

    public double getTempoPasseio() {
        return tempoPasseio;
    }

    public void setTempoPasseio(double tempoPasseio) {
        this.tempoPasseio = tempoPasseio;
    }

    public List<Porte> getPortesAceitos() {
        return portesAceitos;
    }

    public void setPortesAceitos(List<Porte> portesAceitos) {
        this.portesAceitos = portesAceitos;
    }

    public double getValorHoraPasseio() {
        return valorHoraPasseio;
    }

    public void setValorHoraPasseio(double valorHoraPasseio) {
        this.valorHoraPasseio = valorHoraPasseio;
    }
}
