package com.pi.connecpet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_cliente")
public class Cliente extends Pessoa {

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cliente")
    private List<Pet> pets;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cliente")
    private List<Agendamento> agendamentos;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}