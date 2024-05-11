package com.pi.connecpet.serviceImpl;

import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.dto.PetDTO;
import com.pi.connecpet.mapper.ClienteMapper;
import com.pi.connecpet.mapper.PetMapper;
import com.pi.connecpet.model.entity.Cliente;
import com.pi.connecpet.model.entity.Pet;
import com.pi.connecpet.model.enums.Porte;
import com.pi.connecpet.model.enums.Sexo;
import com.pi.connecpet.repository.ClienteRepository;
import com.pi.connecpet.repository.PetRepository;
import com.pi.connecpet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PetMapper petMapper;

    @Override
    public Porte[] getPorteValues() {
        return Porte.values();
    }

    @Override
    public Sexo[] getSexoValues() {
        return Sexo.values();
    }

    @Override
    public void deletePet(PetDTO petDTO) {
        Pet pet = petMapper.toPetEntity(petDTO);
        petRepository.delete(pet);
    }

    @Override
    public void savePet(PetDTO petDTO, Long clienteId) {
        ClienteDTO clienteDTO = clienteRepository
                .findById(clienteId)
                .map(clienteMapper::toClienteDto)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        petDTO.setCliente(clienteMapper.toClienteEntity(clienteDTO));
        petRepository.save(petMapper.toPetEntity(petDTO));
    }

    @Override
    public PetDTO getPetById(Long id) {
        return petRepository.findById(id)
                .map(petMapper::toPetDto)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));
    }

    @Override
    public void updatePet(PetDTO petDTO) {
        Pet pet = petMapper.toPetEntity(petDTO);
        petRepository.save(pet);
    }


}
