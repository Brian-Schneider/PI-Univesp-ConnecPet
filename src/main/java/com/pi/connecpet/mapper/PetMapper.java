package com.pi.connecpet.mapper;

import com.pi.connecpet.dto.PetDTO;
import com.pi.connecpet.model.entity.Pet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetMapper {

    @Autowired
    private ModelMapper mapper;

    public Pet toPetEntity(PetDTO petRequest) {
        return mapper.map(petRequest, Pet.class);
    }

    public PetDTO toPetDto(Pet petResponse) {
        return mapper.map(petResponse, PetDTO.class);
    }

    public List<PetDTO> toListPetDto(List<Pet> pets) {
        return pets
                .stream()
                .map(this::toPetDto)
                .collect(Collectors.toList());
    }
}