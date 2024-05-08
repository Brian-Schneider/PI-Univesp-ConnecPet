package com.pi.connecpet.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_prestador")
public class Prestador extends Pessoa {

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "pet_sitter")
    private boolean ehPetSitter;

    @OneToOne(mappedBy = "prestador", cascade = CascadeType.ALL)
    private PetSitter petSitter;

    @Column(name = "pet_walker")
    private boolean ehPetWalker;

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

    public boolean isEhPetSitter() {
        return ehPetSitter;
    }

    public void setEhPetSitter(boolean ehPetSitter) {
        this.ehPetSitter = ehPetSitter;
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

    public boolean isEhPetWalker() {
        return ehPetWalker;
    }

    public void setEhPetWalker(boolean ehPetWalker) {
        this.ehPetWalker = ehPetWalker;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
