package com.pi.connecpet.repository;

import com.pi.connecpet.model.entity.PetWalker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetWalkerRepository extends JpaRepository<PetWalker, Long> {
    PetWalker findByPrestador_Id(Long id);
}
