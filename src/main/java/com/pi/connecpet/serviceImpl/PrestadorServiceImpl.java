package com.pi.connecpet.serviceImpl;

import com.pi.connecpet.dto.PrestadorDTO;
import com.pi.connecpet.mapper.PrestadorMapper;
import com.pi.connecpet.model.entity.Prestador;
import com.pi.connecpet.repository.PrestadorRepository;
import com.pi.connecpet.service.PrestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrestadorServiceImpl implements PrestadorService {

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private PrestadorMapper prestadorMapper;

    public List<PrestadorDTO> getAllPrestadores(String tipo) {
        List<Prestador> prestadores;
        if (tipo == null || tipo.isEmpty()) {
            prestadores = prestadorRepository.findAll();
        } else if (tipo.equals("PetSitter")) {
            prestadores = prestadorRepository.findByEhPetSitter(true);
        } else if (tipo.equals("PetWalker")) {
            prestadores = prestadorRepository.findByEhPetWalker(true);
        } else {
            prestadores = new ArrayList<>();
        }
        return prestadorMapper.toListPrestadorDto(prestadores);
    }


    @Override
    public void savePrestador(PrestadorDTO prestadorDTO) {

    }

    @Override
    public PrestadorDTO getPrestadorById(Long id) {
        return null;
    }

    @Override
    public void updatePrestador(PrestadorDTO prestadorDTO) {

    }

    @Override
    public void deletePrestador(PrestadorDTO prestadorDTO) {

    }
}
