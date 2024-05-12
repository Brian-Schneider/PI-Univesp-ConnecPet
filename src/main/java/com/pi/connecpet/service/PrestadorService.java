package com.pi.connecpet.service;

import com.pi.connecpet.dto.PrestadorDTO;

import java.util.List;

public interface PrestadorService {

    PrestadorDTO getPrestadorWithSitterAndOrWalkerById(Long id);

    public PrestadorDTO getPrestadorById(Long id);

    void updatePrestador(PrestadorDTO prestadorDTO);

    void deletePrestador(PrestadorDTO prestadorDTO);

    List<PrestadorDTO> getAllPrestadores(String tipo);

    PrestadorDTO savePrestador(PrestadorDTO prestadorDTO,
                                   boolean registroPetSitter,
                                   boolean registroPetWalkerprestadorDTO);

    PrestadorDTO findById(Long prestadorId);
}
