package com.pi.connecpet.service;

import com.pi.connecpet.dto.PetDTO;

public interface PetService {
    void savePet(PetDTO petDTO, Long clienteId);

    PetDTO getPetById(Long id);

    void updatePet(PetDTO petDTO);

    Object getPorteValues();

    Object getSexoValues();

    void deletePet(PetDTO petDTO);
}
