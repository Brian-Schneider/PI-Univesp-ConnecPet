package com.pi.connecpet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pi.connecpet.model.entity.Agendamento;
import com.pi.connecpet.model.entity.Cliente;
import com.pi.connecpet.model.enums.Porte;
import com.pi.connecpet.model.enums.Sexo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PetDTO {

    private Long id;

    @NotNull(message = "O campo Nome do Pet é obrigatório")
    @Size(min = 2, max = 50, message = "O campo Nome do Pet deve ter entre 2 e 50 caracteres")
    private String nomePet;

    @NotNull(message = "O campo Espécie é obrigatório")
    @Size(min = 2, max = 20, message = "O campo Espécie deve ter entre 2 e 20 caracteres")
    private String especie;

    @NotNull(message = "O campo Raça é obrigatório")
    @Size(min = 2, max = 20, message = "O campo Raça deve ter entre 2 e 20 caracteres")
    private String raca;

    @NotNull(message = "O campo Idade é obrigatório")
    private int idade;

    @Size(min = 2, max = 20, message = "O campo Cor deve ter entre 2 e 20 caracteres")
    private String cor;

    @NotNull(message = "O campo Porte é obrigatório")
    private Porte porte;

    @NotNull(message = "O campo Sexo é obrigatório")
    private Sexo sexo;

    @Size(max = 500, message = "O campo Observações deve ter no máximo 500 caracteres")
    private String observacoes;

    @Size(max = 2000, message = "A URL não deve exceder 2000 caracteres")
    private String foto;

    @JsonIgnoreProperties("pets")
    private Cliente cliente;

    private Long clienteId;

    @JsonIgnoreProperties("pet")
    private List<Agendamento> agendamentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
