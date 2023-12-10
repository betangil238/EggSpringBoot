package com.estancias.ejercicio.Service;
import com.estancias.ejercicio.Persistence.entity.Casa;
import com.estancias.ejercicio.Persistence.repository.CasaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasaService {

    private final CasaRepository casaRepository;
    @Autowired
    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    @Transactional
    public Casa guardarUsuario(Casa casa){
        return this.casaRepository.save(casa);
    }

    public List<Casa> obtenerTodos(){
        return this.casaRepository.findAll();
    }

    public Casa obtenerPorId(Long id){
        return this.casaRepository.findById(id).orElse(null);
    }

    public void BorrarPorId(long id){
        this.casaRepository.deleteById(id);
    }

    public boolean existePorId(long id){
        return this.casaRepository.existsById(id);
    }
}
