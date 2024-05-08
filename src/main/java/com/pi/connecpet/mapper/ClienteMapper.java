package com.pi.connecpet.mapper;

import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.model.entity.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    @Autowired
    private ModelMapper mapper;

    public Cliente toClienteEntity(ClienteDTO clienteRequest) {
        return mapper.map(clienteRequest, Cliente.class);
    }

    public ClienteDTO toClienteDto(Cliente clienteResponse) {
        return mapper.map(clienteResponse, ClienteDTO.class);
    }

    public List<ClienteDTO> toListClienteDto(List<Cliente> clientes) {
        return clientes
                .stream()
                .map(this::toClienteDto)
                .collect(Collectors.toList());
    }


}
