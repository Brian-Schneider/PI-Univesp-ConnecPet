package com.pi.connecpet.mapper;

import com.pi.connecpet.dto.PetWalkerDTO;
import com.pi.connecpet.model.entity.PetWalker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetWalkerMapper {
    @Autowired
    private ModelMapper mapper;

    public PetWalker toPetWalkerEntity(PetWalkerDTO petWalkerRequest) {
        return mapper.map(petWalkerRequest, PetWalker.class);
    }

    public PetWalkerDTO toPetWalkerDto(PetWalker petWalkerResponse) {
        return mapper.map(petWalkerResponse, PetWalkerDTO.class);
    }

    public List<PetWalkerDTO> toListPetWalkerDto(List<PetWalker> petWalkeres) {
        return petWalkeres
                .stream()
                .map(this::toPetWalkerDto)
                .collect(Collectors.toList());
    }
}
