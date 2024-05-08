package com.pi.connecpet.mapper;

import com.pi.connecpet.dto.AgendamentoDTO;
import com.pi.connecpet.model.entity.Agendamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgendamentoMapper {

    @Autowired
    private ModelMapper mapper;

    public Agendamento toAgendamentoEntity(AgendamentoDTO agendamentoRequest) {
        return mapper.map(agendamentoRequest, Agendamento.class);
    }

    public AgendamentoDTO toAgendamentoDto(Agendamento agendamentoResponse) {
        return mapper.map(agendamentoResponse, AgendamentoDTO.class);
    }

    public List<AgendamentoDTO> toListAgendamentoDto(List<Agendamento> agendamentos) {
        return agendamentos
                .stream()
                .map(this::toAgendamentoDto)
                .collect(Collectors.toList());
    }

}
