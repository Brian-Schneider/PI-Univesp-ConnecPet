package com.pi.connecpet.repository;

import com.pi.connecpet.model.entity.PetSitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetSitterRepository extends JpaRepository<PetSitter, Long> {
}
