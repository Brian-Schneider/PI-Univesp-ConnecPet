package com.pi.connecpet.model.entity;

import com.pi.connecpet.model.enums.Porte;
import com.pi.connecpet.model.enums.Sexo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_pet")
    private String nomePet;

    @Column(name = "especie")
    private String especie;

    @Column(name = "raca")
    private String raca;

    @Column(name = "idade")
    private int idade;

    @Column(name = "cor")
    private String cor;

    @Column(name = "porte")
    @Enumerated(EnumType.ORDINAL)
    private Porte porte;

    @Column(name = "sexo")
    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "foto")
    private String foto;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
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
