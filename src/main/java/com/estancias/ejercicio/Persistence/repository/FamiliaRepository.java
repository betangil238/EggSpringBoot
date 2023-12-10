package com.estancias.ejercicio.Persistence.repository;

import com.estancias.ejercicio.Persistence.entity.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia,Long> {
}
