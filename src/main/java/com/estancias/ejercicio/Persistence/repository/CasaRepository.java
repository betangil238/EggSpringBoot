package com.estancias.ejercicio.Persistence.repository;

import com.estancias.ejercicio.Persistence.entity.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository extends JpaRepository<Casa,Long> {
}
