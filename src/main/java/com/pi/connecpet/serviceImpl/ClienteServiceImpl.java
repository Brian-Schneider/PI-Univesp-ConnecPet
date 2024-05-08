package com.pi.connecpet.serviceImpl;

import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.mapper.ClienteMapper;
import com.pi.connecpet.model.entity.Cliente;
import com.pi.connecpet.repository.ClienteRepository;
import com.pi.connecpet.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClienteDTO> getAllClientes() {
        return clienteMapper
                .toListClienteDto(clienteRepository
                        .findAll());
    }
}