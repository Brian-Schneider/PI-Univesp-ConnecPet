package com.pi.connecpet.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primeiro_nome")
    @NotNull(message = "O campo Nome é obrigatório")
    @Size(min = 2, max = 50, message = "O campo Nome deve ter entre 2 e 50 caracteres")
    private String primeiroNome;

    @Column(name = "sobrenome")
    @NotNull(message = "O campo Sobrenome é obrigatório")
    @Size(min = 2, max = 50, message = "O campo Sobrenome deve ter entre 2 e 50 caracteres")
    private String sobrenome;

    @Column(name = "email")
    @NotNull(message = "O campo Email é obrigatório")
    @Size(max = 60, message = "O campo Email deve ter no máximo 60 caracteres")
    @Email(message = "Deve ser um Email válido")
    private String email;

    @Column(name = "tel_contato")
    @NotNull(message = "O campo Telefone é obrigatório")
    @Size(max = 14, message = "O campo Telefone deve ter no máximo 14 caracteres")
    private String telContato;

    @Column(name = "tel_alternativo")
    @Size(max = 14, message = "O campo Telefone Alternativo deve ter no máximo 14 caracteres")
    private String telContatoAlternativo;

    @Column(name = "endereco")
    @NotNull(message = "O campo Endereço é obrigatório")
    @Size(max = 100, message = "O campo Endereço deve ter no máximo 100 caracteres")
    private String endereco;

    @Column(name = "cidade")
    @NotNull(message = "O campo Bairro é obrigatório")
    @Size(max = 50, message = "O campo Bairro deve ter no máximo 50 caracteres")
    private String cidade;

    @Column(name = "estado")
    @NotNull(message = "O campo Cidade é obrigatório")
    @Size(max = 50, message = "O campo Cidade deve ter no máximo 50 caracteres")
    private String estado;

    @Column(name = "cep")
    @NotNull(message = "O campo CEP é obrigatório")
    @Size(max = 9, message = "O campo CEP deve ter no máximo 9 caracteres")
    private String cep;

    @Column(name = "foto")
    @Size(max = 2000, message = "A URL não deve exceder 2000 caracteres")
    private String foto;

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
