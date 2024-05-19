package com.pi.connecpet.repository;

import com.pi.connecpet.model.entity.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

    List<Prestador> findByIsPetSitter(boolean b);

    List<Prestador> findByIsPetWalker(boolean b);


}
