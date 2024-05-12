package com.pi.connecpet.service;

import com.pi.connecpet.dto.PetDTO;

import java.util.List;

public interface PetService {
    void savePet(PetDTO petDTO, Long clienteId);

    PetDTO getPetById(Long id);

    void updatePet(PetDTO petDTO);

    Object getPorteValues();

    Object getSexoValues();

    void deletePet(PetDTO petDTO);

    List<PetDTO> getAllPets();

}
