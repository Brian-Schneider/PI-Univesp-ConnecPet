package com.pi.connecpet.mapper;

import com.pi.connecpet.dto.PetSitterDTO;
import com.pi.connecpet.model.entity.PetSitter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetSitterMapper {

    @Autowired
    private ModelMapper mapper;

    public PetSitter toPetSitterEntity(PetSitterDTO petSitterRequest) {
        return mapper.map(petSitterRequest, PetSitter.class);
    }

    public PetSitterDTO toPetSitterDto(PetSitter petSitterResponse) {
        return mapper.map(petSitterResponse, PetSitterDTO.class);
    }

    public List<PetSitterDTO> toListPetSitterDto(List<PetSitter> petSitteres) {
        return petSitteres
                .stream()
                .map(this::toPetSitterDto)
                .collect(Collectors.toList());
    }

}