package com.pi.connecpet.impl;

import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.dto.PetDTO;
import com.pi.connecpet.mapper.ClienteMapper;
import com.pi.connecpet.mapper.PetMapper;
import com.pi.connecpet.model.entity.Cliente;
import com.pi.connecpet.repository.ClienteRepository;
import com.pi.connecpet.service.ClienteService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

import java.util.Collections;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PetMapper petMapper;

    @Override
    public List<ClienteDTO> getAllClientes() {
        return clienteMapper
                .toListClienteDto(clienteRepository
                        .findAll());
    }

    @Override
    @Transactional
    public ClienteDTO getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (cliente == null) {
            throw new NullPointerException("Cliente é Null");
        }

        ClienteDTO clienteDTO = clienteMapper.toClienteDto(cliente);
        List<PetDTO> pets = cliente.getPets().stream()
                .map(petMapper::toPetDto)
                .collect(Collectors.toList());
        clienteDTO.setPets(pets);
        return clienteDTO;
    }

    @Override
    public void saveCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toClienteEntity(clienteDTO);
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toClienteEntity(clienteDTO);
        clienteRepository.delete(cliente);
    }
}
