package com.pi.connecpet.impl;

import com.pi.connecpet.dto.PetWalkerDTO;
import com.pi.connecpet.dto.PrestadorDTO;
import com.pi.connecpet.mapper.PrestadorMapper;
import com.pi.connecpet.mapper.PetWalkerMapper;
import com.pi.connecpet.model.entity.PetWalker;
import com.pi.connecpet.repository.PetWalkerRepository;
import com.pi.connecpet.repository.PrestadorRepository;
import com.pi.connecpet.service.PetWalkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetWalkerServiceImpl implements PetWalkerService {

    @Autowired
    private PetWalkerRepository petWalkerRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private PetWalkerMapper petWalkerMapper;

    @Autowired
    private PrestadorMapper prestadorMapper;


    @Override
    public void savePetWalker(PetWalkerDTO petWalkerDTO, Long prestadorId) {

        PrestadorDTO prestadorDTO = prestadorRepository
                .findById(prestadorId)
                .map(prestadorMapper::toPrestadorDto)
                .orElseThrow(() -> new RuntimeException("Prestador não encontrado"));

        petWalkerDTO.setPrestador(prestadorMapper.toPrestadorEntity(prestadorDTO));

        petWalkerRepository.save(petWalkerMapper.toPetWalkerEntity(petWalkerDTO));
    }

    @Override
    public PetWalkerDTO getPetWalkerByPrestadorId(Long prestadorId) {
        PetWalker petWalker = Optional.ofNullable(petWalkerRepository
                        .findByPrestador_Id(prestadorId))
                .orElseThrow(() -> new RuntimeException("Pet Walker não encontrado para o Prestador id: " + prestadorId));
        return petWalkerMapper.toPetWalkerDto(petWalker);
    }
}
