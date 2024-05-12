package com.pi.connecpet.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_prestador")
public class Prestador extends Pessoa {

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "pet_sitter")
    private boolean isPetSitter;

    @OneToOne(mappedBy = "prestador", cascade = CascadeType.ALL)
    private PetSitter petSitter;

    @Column(name = "pet_walker")
    private boolean isPetWalker;

    @OneToOne(mappedBy = "prestador", cascade = CascadeType.ALL)
    private PetWalker petWalker;

    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean getIsPetSitter() {
        return isPetSitter;
    }

    public void setIsPetSitter(boolean isPetSitter) {
        this.isPetSitter = isPetSitter;
    }

    public PetSitter getPetSitter() {
        return petSitter;
    }

    public void setPetSitter(PetSitter petSitter) {
        this.petSitter = petSitter;
    }

    public PetWalker getPetWalker() {
        return petWalker;
    }

    public void setPetWalker(PetWalker petWalker) {
        this.petWalker = petWalker;
    }

    public boolean getIsPetWalker() {
        return isPetWalker;
    }

    public void setisPetWalker(boolean isPetWalker) {
        this.isPetWalker = isPetWalker;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
