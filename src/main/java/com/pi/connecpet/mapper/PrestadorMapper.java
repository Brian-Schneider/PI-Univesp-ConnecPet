package com.pi.connecpet.mapper;

import com.pi.connecpet.dto.PrestadorDTO;
import com.pi.connecpet.model.entity.Prestador;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrestadorMapper {

    @Autowired
    private ModelMapper mapper;

    public Prestador toPrestadorEntity(PrestadorDTO prestadorRequest) {
        return mapper.map(prestadorRequest, Prestador.class);
    }

    public PrestadorDTO toPrestadorDto(Prestador prestadorResponse) {
        return mapper.map(prestadorResponse, PrestadorDTO.class);
    }

    public List<PrestadorDTO> toListPrestadorDto(List<Prestador> prestadores) {
        return prestadores
                .stream()
                .map(this::toPrestadorDto)
                .collect(Collectors.toList());
    }
}
