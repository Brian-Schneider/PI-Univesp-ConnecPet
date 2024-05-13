package com.pi.connecpet.impl;

import com.pi.connecpet.dto.PetSitterDTO;
import com.pi.connecpet.dto.PrestadorDTO;
import com.pi.connecpet.mapper.PetSitterMapper;
import com.pi.connecpet.mapper.PrestadorMapper;
import com.pi.connecpet.model.entity.PetSitter;
import com.pi.connecpet.repository.PetSitterRepository;
import com.pi.connecpet.repository.PrestadorRepository;
import com.pi.connecpet.service.PetSitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetSitterServiceImpl implements PetSitterService {

    @Autowired
    private PetSitterRepository petSitterRepository;

    @Autowired
    private PetSitterMapper petSitterMapper;
    @Autowired
    private PrestadorMapper prestadorMapper;
    @Autowired
    private PrestadorRepository prestadorRepository;

    @Override
    public void savePetSitter(PetSitterDTO petSitterDTO, Long prestadorID) {

        PrestadorDTO prestadorDTO = prestadorRepository
                .findById(prestadorID)
                .map(prestadorMapper::toPrestadorDto)
                .orElseThrow(() -> new RuntimeException("Prestador não encontrado"));


        petSitterDTO.setPrestador(prestadorMapper.toPrestadorEntity(prestadorDTO));

        petSitterRepository.save(petSitterMapper.toPetSitterEntity(petSitterDTO));



    }

    @Override
    public PetSitterDTO getPetSitterByPrestadorId(Long prestadorId) {
        PetSitter petSitter = Optional.ofNullable(petSitterRepository
                        .findByPrestador_Id(prestadorId))
                .orElseThrow(() -> new RuntimeException("Pet Sitter não encontrado para o Prestador id: " + prestadorId));
        return petSitterMapper.toPetSitterDto(petSitter);
    }
}
