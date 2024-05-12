package com.pi.connecpet.service;

import com.pi.connecpet.dto.PetSitterDTO;

public interface PetSitterService {
    void savePetSitter(PetSitterDTO petSitterDTO, Long prestadorId);

}
