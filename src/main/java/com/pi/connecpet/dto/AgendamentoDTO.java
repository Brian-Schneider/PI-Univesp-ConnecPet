package com.pi.connecpet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pi.connecpet.model.entity.Cliente;
import com.pi.connecpet.model.entity.Pet;
import com.pi.connecpet.model.entity.Prestador;
import com.pi.connecpet.model.enums.TipoServico;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AgendamentoDTO {

    private Long id;

    @JsonIgnoreProperties("agendamentos")
    private Cliente cliente;

    @JsonIgnoreProperties("agendamentos")
    private Pet pet;

    @JsonIgnoreProperties("agendamentos")
    private Prestador prestador;

    @NotNull(message = "O campo Tipo de Serviço é obrigatório")
    private TipoServico tipoServico;

    @NotNull(message = "O campo Data Agendamento é obrigatório")
    private LocalDateTime dataAgendamento;

    @NotNull(message = "O campo Hora Agendamento é obrigatório")
    private LocalDateTime horaAgendamento;

    @NotNull(message = "O campo Valor do Serviço é obrigatório")
    private double valorServico;

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

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
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

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }
}
