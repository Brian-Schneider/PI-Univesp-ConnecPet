package com.pi.connecpet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pi.connecpet.model.entity.Agendamento;
import com.pi.connecpet.model.entity.PetSitter;
import com.pi.connecpet.model.entity.PetWalker;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PrestadorDTO {

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
    @Size(max = 14, message = "O campo Telefone deve ter no máximo 14 caracteres")
    private String telContato;

    @Size(max = 14, message = "O campo Telefone Alternativo deve ter no máximo 14 caracteres")
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

    @Size(max = 2000, message = "A URL não deve exceder 2000 caracteres")
    private String foto;

    @NotNull(message = "O campo CPF é obrigatório")
    @Size(max = 14, message = "O campo CPF deve ter no máximo 11 caracteres")
    private String cpf;


    @JsonIgnoreProperties("prestador")
    private PetSitterDTO petSitterDTO;


    @JsonIgnoreProperties("prestador")
    private PetWalkerDTO petWalkerDTO;

    @JsonIgnoreProperties("prestador")
    private List<Agendamento> agendamentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo Nome é obrigatório") @Size(min = 2, max = 50, message = "O campo Nome deve ter entre 2 e 50 caracteres") String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(@NotNull(message = "O campo Nome é obrigatório") @Size(min = 2, max = 50, message = "O campo Nome deve ter entre 2 e 50 caracteres") String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public @NotNull(message = "O campo Sobrenome é obrigatório") @Size(min = 2, max = 50, message = "O campo Sobrenome deve ter entre 2 e 50 caracteres") String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(@NotNull(message = "O campo Sobrenome é obrigatório") @Size(min = 2, max = 50, message = "O campo Sobrenome deve ter entre 2 e 50 caracteres") String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public @NotNull(message = "O campo Email é obrigatório") @Size(max = 60, message = "O campo Email deve ter no máximo 60 caracteres") @Email(message = "Deve ser um Email válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "O campo Email é obrigatório") @Size(max = 60, message = "O campo Email deve ter no máximo 60 caracteres") @Email(message = "Deve ser um Email válido") String email) {
        this.email = email;
    }

    public @NotNull(message = "O campo Telefone é obrigatório") @Size(max = 14, message = "O campo Telefone deve ter no máximo 14 caracteres") String getTelContato() {
        return telContato;
    }

    public void setTelContato(@NotNull(message = "O campo Telefone é obrigatório") @Size(max = 14, message = "O campo Telefone deve ter no máximo 14 caracteres") String telContato) {
        this.telContato = telContato;
    }

    public @Size(max = 14, message = "O campo Telefone Alternativo deve ter no máximo 14 caracteres") String getTelContatoAlternativo() {
        return telContatoAlternativo;
    }

    public void setTelContatoAlternativo(@Size(max = 14, message = "O campo Telefone Alternativo deve ter no máximo 14 caracteres") String telContatoAlternativo) {
        this.telContatoAlternativo = telContatoAlternativo;
    }

    public @NotNull(message = "O campo Endereço é obrigatório") @Size(max = 100, message = "O campo Endereço deve ter no máximo 100 caracteres") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo Endereço é obrigatório") @Size(max = 100, message = "O campo Endereço deve ter no máximo 100 caracteres") String endereco) {
        this.endereco = endereco;
    }

    public @NotNull(message = "O campo Bairro é obrigatório") @Size(max = 50, message = "O campo Bairro deve ter no máximo 50 caracteres") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotNull(message = "O campo Bairro é obrigatório") @Size(max = 50, message = "O campo Bairro deve ter no máximo 50 caracteres") String cidade) {
        this.cidade = cidade;
    }

    public @NotNull(message = "O campo Cidade é obrigatório") @Size(max = 50, message = "O campo Cidade deve ter no máximo 50 caracteres") String getEstado() {
        return estado;
    }

    public void setEstado(@NotNull(message = "O campo Cidade é obrigatório") @Size(max = 50, message = "O campo Cidade deve ter no máximo 50 caracteres") String estado) {
        this.estado = estado;
    }

    public @NotNull(message = "O campo CEP é obrigatório") @Size(max = 9, message = "O campo CEP deve ter no máximo 9 caracteres") String getCep() {
        return cep;
    }

    public void setCep(@NotNull(message = "O campo CEP é obrigatório") @Size(max = 9, message = "O campo CEP deve ter no máximo 9 caracteres") String cep) {
        this.cep = cep;
    }

    public @Size(max = 2000, message = "A URL não deve exceder 2000 caracteres") String getFoto() {
        return foto;
    }

    public void setFoto(@Size(max = 2000, message = "A URL não deve exceder 2000 caracteres") String foto) {
        this.foto = foto;
    }

    public @NotNull(message = "O campo CPF é obrigatório") @Size(max = 14, message = "O campo CPF deve ter no máximo 11 caracteres") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo CPF é obrigatório") @Size(max = 14, message = "O campo CPF deve ter no máximo 11 caracteres") String cpf) {
        this.cpf = cpf;
    }



    public PetSitterDTO getPetSitterDTO() {
        return petSitterDTO;
    }

    public void setPetSitterDTO(PetSitterDTO petSitterDTO) {
        this.petSitterDTO = petSitterDTO;
    }

    private boolean isPetSitter;

    public boolean getIsPetSitter() {
        return isPetSitter;
    }

    public void setIsPetSitter(boolean isPetSitter) {
        this.isPetSitter = isPetSitter;
    }

    private boolean isPetWalker;

    public boolean getIsPetWalker() {
        return isPetWalker;
    }

    public void setIsPetWalker(boolean isPetWalker) {
        this.isPetWalker = isPetWalker;
    }

    public PetWalkerDTO getPetWalkerDTO() {
        return petWalkerDTO;
    }

    public void setPetWalkerDTO(PetWalkerDTO petWalkerDTO) {
        this.petWalkerDTO = petWalkerDTO;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
