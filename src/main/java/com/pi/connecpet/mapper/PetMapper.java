package com.pi.connecpet.mapper;

import com.pi.connecpet.dto.PetDTO;
import com.pi.connecpet.model.entity.Cliente;
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
        Pet pet = mapper.map(petRequest, Pet.class);
        if (petRequest.getClienteId() != null) {
            Cliente cliente = new Cliente();
            cliente.setId(petRequest.getClienteId());
            pet.setCliente(cliente);
        }
        return pet;
    }

    public PetDTO toPetDto(Pet petResponse) {
        PetDTO petDTO = mapper.map(petResponse, PetDTO.class);
        if (petResponse.getCliente() != null) {
            petDTO.setClienteId(petResponse.getCliente().getId());
        }
        return petDTO;
    }

    public List<PetDTO> toListPetDto(List<Pet> pets) {
        return pets
                .stream()
                .map(this::toPetDto)
                .collect(Collectors.toList());
    }
}