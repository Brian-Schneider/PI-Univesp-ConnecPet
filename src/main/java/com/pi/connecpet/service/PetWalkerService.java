package com.pi.connecpet.service;

import com.pi.connecpet.dto.PetWalkerDTO;

public interface PetWalkerService {
    void savePetWalker(PetWalkerDTO petWalkerDTO, Long prestadorId);

    PetWalkerDTO getPetWalkerByPrestadorId(Long prestadorId);
}
