package com.pi.connecpet.service;

import com.pi.connecpet.dto.PrestadorDTO;

import java.util.List;
import java.util.Optional;

public interface PrestadorService {

    PrestadorDTO getPrestadorWithSitterAndOrWalkerById(Long id);

    PrestadorDTO getPrestadorById(Long id);

    void updatePrestador(PrestadorDTO prestadorDTO, Long Id);

    void deletePrestador(PrestadorDTO prestadorDTO);

    List<PrestadorDTO> getAllPrestadores(String tipo);

    PrestadorDTO savePrestador(PrestadorDTO prestadorDTO,
                                   boolean registroPetSitter,
                                   boolean registroPetWalkerprestadorDTO);

    PrestadorDTO findById(Long prestadorId);

    void validarPrestadorId(Long prestadorId);

}
