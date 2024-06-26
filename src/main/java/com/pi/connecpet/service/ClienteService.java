package com.pi.connecpet.service;

import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.model.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> getAllClientes();

    ClienteDTO getClienteById(Long id);

    void saveCliente(ClienteDTO clienteDTO);

    void deleteCliente(ClienteDTO clienteDTO);
}
