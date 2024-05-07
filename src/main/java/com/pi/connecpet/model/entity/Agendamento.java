package com.pi.connecpet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_agendamento",
        uniqueConstraints = @UniqueConstraint(columnNames = {"data_hora", "id_provider"}))
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @JsonIgnoreProperties("agendamentos")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id")
    @JsonIgnoreProperties("agendamentos")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "id_prestador", referencedColumnName = "id")
    @JsonIgnoreProperties("agendamentos")
    private Prestador prestador;

    @Column(name = "data_agendamento")
    @NotNull(message = "O campo Data Agendamento é obrigatório")
    private LocalDateTime dataAgendamento;

    @Column(name = "hora_agendamento")
    @NotNull(message = "O campo Hora Agendamento é obrigatório")
    private LocalDateTime horaAgendamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDateTime getHoraAgendamento() {
        return horaAgendamento;
    }

    public void setHoraAgendamento(LocalDateTime horaAgendamento) {
        this.horaAgendamento = horaAgendamento;
    }
}


