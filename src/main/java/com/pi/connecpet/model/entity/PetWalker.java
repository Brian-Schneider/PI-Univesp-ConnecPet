package com.pi.connecpet.model.entity;

import com.pi.connecpet.model.enums.Porte;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "tb_walker")
public class PetWalker{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestador", referencedColumnName = "id")
    private Prestador prestador;

    @Column(name = "tempo_passeio")
    private double tempoPasseio;

    @Column(name = "portes_aceitos")
    private List<Porte> portesAceitos;

    @Column(name = "valor_hora_passeio")
    private double valorHoraPasseio;

    public double getTempoPasseio() {
        return tempoPasseio;
    }

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
}
