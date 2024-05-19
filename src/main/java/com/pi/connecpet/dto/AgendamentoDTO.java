package com.pi.connecpet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pi.connecpet.model.enums.StatusAgendamento;
import com.pi.connecpet.model.enums.TipoServico;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AgendamentoDTO {

    private Long id;

    @JsonIgnoreProperties("agendamentos")
    private ClienteDTO cliente;

    private Long idCliente;

    @JsonIgnoreProperties("agendamentos")
    private PetDTO pet;

    private Long idPet;

    @JsonIgnoreProperties("agendamentos")
    private PrestadorDTO prestador;

    private Long idPrestador;

    @NotNull(message = "O campo Tipo de Serviço é obrigatório")
    private TipoServico tipoServico;

    @NotNull(message = "O campo Data Agendamento é obrigatório")
    private LocalDate dataAgendamento;

    private String dataAgendamentoFormatada;

    @NotNull(message = "O campo Hora Agendamento é obrigatório")
    private LocalTime horaAgendamento;

    @NotNull(message = "O campo Status é obrigatório")
    private StatusAgendamento status;

    @NotNull(message = "O campo Valor do Serviço é obrigatório")
    private BigDecimal valorServico;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public PetDTO getPet() {
        return pet;
    }

    public void setPet(PetDTO pet) {
        this.pet = pet;
    }

    public PrestadorDTO getPrestador() {
        return prestador;
    }

    public void setPrestador(PrestadorDTO prestador) {
        this.prestador = prestador;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataAgendamentoFormatada = dataAgendamento.format(formatter);
    }

    public String getDataAgendamentoFormatada() {
        return dataAgendamentoFormatada;
    }

    public void setDataAgendamentoFormatada(LocalDate dataAgendamentoFormatada) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataAgendamentoFormatada = dataAgendamentoFormatada.format(formatter);
    }

    public LocalTime getHoraAgendamento() {
        return horaAgendamento;
    }

    public void setHoraAgendamento(LocalTime horaAgendamento) {
        this.horaAgendamento = horaAgendamento;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

    public Long getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(Long idPrestador) {
        this.idPrestador = idPrestador;
    }
}
