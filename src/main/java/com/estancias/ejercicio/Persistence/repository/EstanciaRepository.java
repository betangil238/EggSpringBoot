package com.estancias.ejercicio.Persistence.repository;

import com.estancias.ejercicio.Persistence.entity.Estancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstanciaRepository extends JpaRepository<Estancia,Long> {
}
