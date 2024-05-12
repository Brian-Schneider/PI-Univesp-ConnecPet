package com.pi.connecpet.service;

import com.pi.connecpet.dto.PrestadorDTO;

import java.util.List;

public interface PrestadorService {
    void savePrestador(PrestadorDTO prestadorDTO);

    PrestadorDTO getPrestadorById(Long id);

    void updatePrestador(PrestadorDTO prestadorDTO);

    void deletePrestador(PrestadorDTO prestadorDTO);

    List<PrestadorDTO> getAllPrestadores(String tipo);
}
