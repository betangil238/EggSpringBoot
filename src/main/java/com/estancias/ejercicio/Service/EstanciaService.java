package com.estancias.ejercicio.Service;

import com.estancias.ejercicio.Persistence.entity.Estancia;
import com.estancias.ejercicio.Persistence.repository.EstanciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstanciaService {

    private final EstanciaRepository estanciaRepository;
    @Autowired
    public EstanciaService(EstanciaRepository estanciaRepository) {
        this.estanciaRepository = estanciaRepository;
    }

    @Transactional
    public Estancia guardarEstancia(Estancia estancia){
        return this.estanciaRepository.save(estancia);
    }

    public List<Estancia> obtenerTodos(){
        return this.estanciaRepository.findAll();
    }

    public Estancia obtenerPorId(Long id){
        return this.estanciaRepository.findById(id).orElse(null);
    }

    public void BorrarPorId(long id){
        this.estanciaRepository.deleteById(id);
    }

    public boolean existePorId(long id){
        return this.estanciaRepository.existsById(id);
    }
}

