package com.pi.connecpet.dto;

import com.pi.connecpet.model.entity.Prestador;
import com.pi.connecpet.model.enums.Porte;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PetWalkerDTO {

    private Long id;

    @NotNull(message = "O campo Prestador é obrigatório")
    private Prestador prestador;

    private Long prestadorId;

    @NotNull(message = "O campo Tempo de Passeio é obrigatório")
    private double tempoPasseio;

    @NotNull(message = "O campo Portes Aceitos é obrigatório")
    private List<Porte> portesAceitos;

    @NotNull(message = "O campo Valor Hora Passeio é obrigatório")
    private double valorHoraPasseio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public double getTempoPasseio() {
        return tempoPasseio;
    }

    public void setTempoPasseio(double tempoPasseio) {
        this.tempoPasseio = tempoPasseio;
    }

    public List<Porte> getPortesAceitos() {
        return portesAceitos;
    }

    public void setPortesAceitos(List<Porte> portesAceitos) {
        this.portesAceitos = portesAceitos;
    }

    public double getValorHoraPasseio() {
        return valorHoraPasseio;
    }

    public void setValorHoraPasseio(double valorHoraPasseio) {
        this.valorHoraPasseio = valorHoraPasseio;
    }

    public Long getPrestadorId() {
        return prestadorId;
    }

    public void setPrestadorId(Long prestadorId) {
        this.prestadorId = prestadorId;
    }
}
