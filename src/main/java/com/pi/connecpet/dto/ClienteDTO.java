package com.pi.connecpet.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pi.connecpet.model.entity.Agendamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Valid
public class ClienteDTO {

    private Long id;

    @NotNull(message = "O campo Nome é obrigatório")
    @Size(min = 2, max = 50, message = "O campo Nome deve ter entre 2 e 50 caracteres")
    private String primeiroNome;

    @NotNull(message = "O campo Sobrenome é obrigatório")
    @Size(min = 2, max = 50, message = "O campo Sobrenome deve ter entre 2 e 50 caracteres")
    private String sobrenome;

    @NotNull(message = "O campo Email é obrigatório")
    @Size(max = 60, message = "O campo Email deve ter no máximo 60 caracteres")
    @Email(message = "Deve ser um Email válido")
    private String email;

    @NotNull(message = "O campo Telefone é obrigatório")
    @Size(min = 14, max = 15, message = "O campo Telefone deve ter 10 ou 11 dígitos")
    private String telContato;

    @Size(min = 14, max = 15, message = "O campo Telefone Alternativo deve ter 10 ou 11 dígitos")
    private String telContatoAlternativo;

    @NotNull(message = "O campo Endereço é obrigatório")
    @Size(max = 100, message = "O campo Endereço deve ter no máximo 100 caracteres")
    private String endereco;

    @NotNull(message = "O campo Bairro é obrigatório")
    @Size(max = 50, message = "O campo Bairro deve ter no máximo 50 caracteres")
    private String cidade;

    @NotNull(message = "O campo Cidade é obrigatório")
    @Size(max = 50, message = "O campo Cidade deve ter no máximo 50 caracteres")
    private String estado;

    @NotNull(message = "O campo CEP é obrigatório")
    @Size(max = 9, message = "O campo CEP deve ter no máximo 9 caracteres")
    private String cep;

    @NotNull(message = "O campo Número da Residência é obrigatório")
    @Size(max = 10, message = "O campo Número da Residência deve ter no máximo 10 caracteres")
    private String numeroResidencia;

    @NotNull(message = "O campo Bairro é obrigatório")
    @Size(max = 50, message = "O campo Bairro deve ter no máximo 50 caracteres")
    private String bairro;

    @Size(max = 2000, message = "A URL não deve exceder 2000 caracteres")
    private String foto;

    @JsonIgnoreProperties("cliente")
    private List<PetDTO> pets;

    @JsonIgnoreProperties("cliente")
    private List<AgendamentoDTO> agendamentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    public String getTelContatoAlternativo() {
        return telContatoAlternativo;
    }

    public void setTelContatoAlternativo(String telContatoAlternativo) {
        this.telContatoAlternativo = telContatoAlternativo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<PetDTO> getPets() {
        return this.pets;
    }

    public void setPets(List<PetDTO> pets) {
        this.pets = pets;
    }

    public List<AgendamentoDTO> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoDTO> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
