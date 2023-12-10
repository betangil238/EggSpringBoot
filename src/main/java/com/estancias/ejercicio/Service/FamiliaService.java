package com.estancias.ejercicio.Service;

import com.estancias.ejercicio.Persistence.entity.Familia;
import com.estancias.ejercicio.Persistence.repository.FamiliaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliaService {

    private final FamiliaRepository familiaRepository;
    @Autowired
    public FamiliaService(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    @Transactional
    public Familia guardarFamilia(Familia familia){
        return this.familiaRepository.save(familia);
    }

    public List<Familia> obtenerTodos(){
        return this.familiaRepository.findAll();
    }

    public Familia obtenerPorId(Long id){
        return this.familiaRepository.findById(id).orElse(null);
    }

    public void BorrarPorId(long id){
        this.familiaRepository.deleteById(id);
    }

    public boolean existePorId(long id){
        return this.familiaRepository.existsById(id);
    }
}
