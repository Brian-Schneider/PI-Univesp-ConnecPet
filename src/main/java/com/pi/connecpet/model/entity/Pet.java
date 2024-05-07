package com.pi.connecpet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pi.connecpet.model.enums.Porte;
import com.pi.connecpet.model.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table (name = "tb_pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_pet")
    @NotNull(message = "O campo Nome do Pet é obrigatório")
    @Size(min = 2, max = 50, message = "O campo Nome do Pet deve ter entre 2 e 50 caracteres")
    private String nomePet;

    @Column(name = "especie")
    @NotNull(message = "O campo Espécie é obrigatório")
    @Size(min = 2, max = 20, message = "O campo Espécie deve ter entre 2 e 20 caracteres")
    private String especie;

    @Column(name = "raca")
    @NotNull(message = "O campo Raça é obrigatório")
    @Size(min = 2, max = 20, message = "O campo Raça deve ter entre 2 e 20 caracteres")
    private String raca;

    @Column(name = "idade")
    @NotNull(message = "O campo Idade é obrigatório")
    private int idade;

    @Column(name = "cor")
    @Size(min = 2, max = 20, message = "O campo Cor deve ter entre 2 e 20 caracteres")
    private String cor;

    @Column(name = "porte")
    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "O campo Porte é obrigatório")
    private Porte porte;

    @Column(name = "sexo")
    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "O campo Sexo é obrigatório")
    private Sexo sexo;

    @Column(name = "observacoes")
    @Size(max = 500, message = "O campo Observações deve ter no máximo 500 caracteres")
    private String observacoes;

    @Size(max = 2000, message = "A URL não deve exceder 2000 caracteres")
    private String foto;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @JsonIgnoreProperties("pets")
    private Cliente cliente;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
}
