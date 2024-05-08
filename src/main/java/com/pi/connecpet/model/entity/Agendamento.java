package com.pi.connecpet.model.entity;


import com.pi.connecpet.model.enums.TipoServico;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_agendamento",
        uniqueConstraints = @UniqueConstraint(columnNames = {"data_hora", "id_provider"}))
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pet", referencedColumnName = "id")
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestador", referencedColumnName = "id")
    private Prestador prestador;

    @Column(name = "tipo_servico")
    @Enumerated(EnumType.ORDINAL)
    private TipoServico tipoServico;

    @Column(name = "data_agendamento")
    private LocalDateTime dataAgendamento;

    @Column(name = "hora_agendamento")
    private LocalDateTime horaAgendamento;

    @Column(name = "valor_servico")
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

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
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


