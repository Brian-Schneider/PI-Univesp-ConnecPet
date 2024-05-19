package com.pi.connecpet.impl;

import com.pi.connecpet.dto.AgendamentoDTO;
import com.pi.connecpet.dto.ClienteDTO;
import com.pi.connecpet.dto.PetDTO;
import com.pi.connecpet.dto.PrestadorDTO;
import com.pi.connecpet.mapper.AgendamentoMapper;
import com.pi.connecpet.mapper.PetMapper;
import com.pi.connecpet.mapper.PrestadorMapper;
import com.pi.connecpet.model.entity.Agendamento;
import com.pi.connecpet.model.entity.Pet;
import com.pi.connecpet.model.entity.Prestador;
import com.pi.connecpet.repository.AgendamentoRepository;
import com.pi.connecpet.repository.PetRepository;
import com.pi.connecpet.repository.PrestadorRepository;
import com.pi.connecpet.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AgendamentoMapper agendamentoMapper;

    @Autowired
    private PrestadorMapper prestadorMapper;

    @Autowired
    private PetMapper petMapper;



    @Override
    public AgendamentoDTO saveAgendamento(AgendamentoDTO agendamentoDTO) {
        Agendamento agendamento = agendamentoMapper.toAgendamentoEntity(agendamentoDTO);
        Agendamento savedAgendamento = agendamentoRepository.save(agendamento);
        return agendamentoMapper.toAgendamentoDto(savedAgendamento);
    }

    @Override
    public void cancelAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }

    @Override
    public AgendamentoDTO updateAgendamento(Long id, AgendamentoDTO agendamentoDTO) {
        Agendamento existingAgendamento = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        Agendamento updatedAgendamento = agendamentoMapper.toAgendamentoEntity(agendamentoDTO);
        updatedAgendamento.setId(existingAgendamento.getId());
        Agendamento savedAgendamento = agendamentoRepository.save(updatedAgendamento);
        return agendamentoMapper.toAgendamentoDto(savedAgendamento);
    }

    @Override
    @Transactional
    public AgendamentoDTO getAgendamento(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        return agendamentoMapper.toAgendamentoDto(agendamento);
    }

    @Override
    public List<AgendamentoDTO> getAllAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return agendamentos.stream()
                .map(agendamentoMapper::toAgendamentoDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PrestadorDTO> getPrestadoresByServiceType(String serviceType) {
        List<Prestador> prestadores;
        if ("PET_WALKER".equals(serviceType)) {
            prestadores = prestadorRepository.findByIsPetWalker(true);
        } else if ("PET_SITTER".equals(serviceType)) {
            prestadores = prestadorRepository.findByIsPetSitter(true);
        } else {
            throw new IllegalArgumentException("Invalid service type: " + serviceType);
        }
        return prestadores.stream()
                .map(prestadorMapper::toPrestadorDto)
                .collect(Collectors.toList());
    }

}