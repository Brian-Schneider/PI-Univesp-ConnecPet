package com.pi.connecpet.impl;

import com.pi.connecpet.dto.PetSitterDTO;
import com.pi.connecpet.dto.PetWalkerDTO;
import com.pi.connecpet.dto.PrestadorDTO;
import com.pi.connecpet.mapper.PetSitterMapper;
import com.pi.connecpet.mapper.PetWalkerMapper;
import com.pi.connecpet.mapper.PrestadorMapper;
import com.pi.connecpet.model.entity.Prestador;
import com.pi.connecpet.repository.PetSitterRepository;
import com.pi.connecpet.repository.PetWalkerRepository;
import com.pi.connecpet.repository.PrestadorRepository;
import com.pi.connecpet.service.PrestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrestadorServiceImpl implements PrestadorService {

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private PetSitterRepository petSitterRepository;

    @Autowired
    private PetWalkerRepository petWalkerRepository;

    @Autowired
    private PrestadorMapper prestadorMapper;

    @Autowired
    private PetSitterMapper petSitterMapper;

    @Autowired
    private PetWalkerMapper petWalkerMapper;

    @Override
    public List<PrestadorDTO> getAllPrestadores(String tipo) {
        List<Prestador> prestadores;
        if (tipo == null || tipo.isEmpty()) {
            prestadores = prestadorRepository.findAll();
        } else if (tipo.equals("PetSitter")) {
            prestadores = prestadorRepository.findByIsPetSitter(true);
        } else if (tipo.equals("PetWalker")) {
            prestadores = prestadorRepository.findByIsPetWalker(true);
        } else {
            prestadores = new ArrayList<>();
        }

        List<PrestadorDTO> prestadorDTO = prestadorMapper.toListPrestadorDto(prestadores);
        return prestadorDTO;
    }

    @Override
    public PrestadorDTO getPrestadorWithSitterAndOrWalkerById(Long id) {
        Prestador prestador = prestadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestador não encontrado"));

        PrestadorDTO prestadorDTO = prestadorMapper.toPrestadorDto(prestador);

        if (prestador.getIsPetSitter()) {
            PetSitterDTO petSitterDTO = petSitterMapper.toPetSitterDto(prestador.getPetSitter());
            prestadorDTO.setPetSitterDTO(petSitterDTO);
        }

        if (prestador.getIsPetWalker()) {
            PetWalkerDTO petWalkerDTO = petWalkerMapper.toPetWalkerDto(prestador.getPetWalker());
            prestadorDTO.setPetWalkerDTO(petWalkerDTO);
        }

        return prestadorDTO;
    }

    @Override
    public PrestadorDTO savePrestador(PrestadorDTO prestadorDTO,
                                          boolean registroPetSitter,
                                          boolean registroPetWalker) {
        // Convert the PrestadorDTO to a Prestador entity
        Prestador prestador = prestadorMapper.toPrestadorEntity(prestadorDTO);

        // Save the Prestador entity in the database
        prestador = prestadorRepository.save(prestador);

        // Set the registerAsPetSitter and registerAsPetWalker properties in the PrestadorDTO
        prestadorDTO.setId(prestador.getId());
        prestadorDTO.setIsPetSitter(registroPetSitter);
        prestadorDTO.setIsPetWalker(registroPetWalker);

        // Return the updated PrestadorDTO
        return prestadorDTO;
    }

    @Override
    public PrestadorDTO findById(Long prestadorId) {
        return null;
    }

    @Override
    public PrestadorDTO getPrestadorById(Long id) {
        return prestadorRepository.findById(id)
                .map(prestadorMapper::toPrestadorDto)
                .orElseThrow(() -> new RuntimeException("Prestador not found with id: " + id));
    }

    @Override
    public void updatePrestador(PrestadorDTO prestadorDTO, Long Id) {

    }

    @Override
    public void validatePrestadorId(Long prestadorId) {
        if (prestadorId == null || prestadorId <= 0) {
            throw new IllegalArgumentException("PrestadorId deve ser um número maior que zero.");
        }
    }


    @Override
    public void deletePrestador(PrestadorDTO prestadorDTO) {

        Prestador prestador = prestadorRepository.findById(prestadorDTO.getId())
                .orElseThrow(() -> new RuntimeException("Prestador não encontrado"));

        if (prestador.getIsPetSitter()) {
            Optional.ofNullable(prestador.getPetSitter())
                    .ifPresent(petSitter -> petSitterRepository.delete(petSitter));
        }

        if (prestador.getIsPetWalker()) {
            Optional.ofNullable(prestador.getPetWalker())
                    .ifPresent(petWalker -> petWalkerRepository.delete(petWalker));
        }

        prestadorRepository.delete(prestador);
    }

}
