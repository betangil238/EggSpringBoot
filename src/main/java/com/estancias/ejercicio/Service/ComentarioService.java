package com.estancias.ejercicio.Service;


import com.estancias.ejercicio.Persistence.entity.Comentario;
import com.estancias.ejercicio.Persistence.repository.ComentarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;
    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Transactional
    public Comentario guardarComentario(Comentario comentario){
        return this.comentarioRepository.save(comentario);
    }

    public List<Comentario> obtenerTodos(){
        return this.comentarioRepository.findAll();
    }

    public Comentario obtenerPorId(Long id){
        return this.comentarioRepository.findById(id).orElse(null);
    }

    public void BorrarPorId(long id){
        this.comentarioRepository.deleteById(id);
    }

    public boolean existePorId(long id){
        return this.comentarioRepository.existsById(id);
    }
}
