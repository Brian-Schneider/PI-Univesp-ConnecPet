package com.pi.connecpet.impl;

import com.pi.connecpet.dto.PetWalkerDTO;
import com.pi.connecpet.mapper.PetWalkerMapper;
import com.pi.connecpet.model.entity.PetWalker;
import com.pi.connecpet.repository.PetWalkerRepository;
import com.pi.connecpet.service.PetWalkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetWalkerServiceImpl implements PetWalkerService {

    @Autowired
    private PetWalkerRepository petWalkerRepository;

    @Autowired
    private PetWalkerMapper petWalkerMapper;

    @Override
    public void savePetWalker(PetWalkerDTO petWalkerDTO) {
        PetWalker petWalker = petWalkerMapper.toPetWalkerEntity(petWalkerDTO);
        petWalkerRepository.save(petWalker);
    }
}
