package com.pi.connecpet.service;

import com.pi.connecpet.dto.AgendamentoDTO;
import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.dto.PetDTO;
import com.pi.connecpet.dto.PrestadorDTO;

import java.util.List;

public interface AgendamentoService {
    AgendamentoDTO saveAgendamento(AgendamentoDTO agendamentoDTO);
    void cancelAgendamento(Long id);
    AgendamentoDTO updateAgendamento(Long id, AgendamentoDTO agendamentoDTO);
    AgendamentoDTO getAgendamento(Long id);
    List<AgendamentoDTO> getAllAgendamentos();

    List<PrestadorDTO> getPrestadoresByServiceType(String serviceType);

}