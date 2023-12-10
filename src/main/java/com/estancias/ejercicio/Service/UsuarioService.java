package com.estancias.ejercicio.Service;

import com.estancias.ejercicio.Persistence.entity.Usuario;
import com.estancias.ejercicio.Persistence.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario guardarUsuario(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodos(){
        return this.usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Long id){
        return this.usuarioRepository.findById(id).orElse(null);
    }

    public void BorrarPorId(long id){
        this.usuarioRepository.deleteById(id);
    }

    public boolean existePorId(long id){
        return this.usuarioRepository.existsById(id);
    }
}
