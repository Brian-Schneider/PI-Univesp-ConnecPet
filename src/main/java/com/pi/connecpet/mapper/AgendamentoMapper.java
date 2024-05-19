package com.pi.connecpet.mapper;

import com.pi.connecpet.dto.AgendamentoDTO;
import com.pi.connecpet.model.entity.Agendamento;
import com.pi.connecpet.model.entity.Cliente;
import com.pi.connecpet.model.entity.Pet;
import com.pi.connecpet.model.entity.Prestador;
import com.pi.connecpet.repository.ClienteRepository;
import com.pi.connecpet.repository.PetRepository;
import com.pi.connecpet.repository.PrestadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgendamentoMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    public Agendamento toAgendamentoEntity(AgendamentoDTO agendamentoRequest) {
        Agendamento agendamento = mapper.map(agendamentoRequest, Agendamento.class);

        Cliente cliente = clienteRepository.findById(agendamentoRequest.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente not found"));
        agendamento.setCliente(cliente);

        Pet pet = petRepository.findById(agendamentoRequest.getIdPet())
                .orElseThrow(() -> new RuntimeException("Pet not found"));
        agendamento.setPet(pet);

        Prestador prestador = prestadorRepository.findById(agendamentoRequest.getIdPrestador())
                .orElseThrow(() -> new RuntimeException("Prestador not found"));
        agendamento.setPrestador(prestador);

        return agendamento;
    }

    public AgendamentoDTO toAgendamentoDto(Agendamento agendamentoResponse) {
        AgendamentoDTO agendamentoDTO = mapper.map(agendamentoResponse, AgendamentoDTO.class);

        agendamentoDTO.setIdCliente(agendamentoResponse.getCliente().getId());
        agendamentoDTO.setIdPet(agendamentoResponse.getPet().getId());
        agendamentoDTO.setIdPrestador(agendamentoResponse.getPrestador().getId());

        return agendamentoDTO;
    }

    public List<AgendamentoDTO> toListAgendamentoDto(List<Agendamento> agendamentos) {
        return agendamentos
                .stream()
                .map(this::toAgendamentoDto)
                .collect(Collectors.toList());
    }
}