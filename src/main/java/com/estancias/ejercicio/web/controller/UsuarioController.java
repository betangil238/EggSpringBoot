package com.estancias.ejercicio.web.controller;

import com.estancias.ejercicio.Persistence.entity.Usuario;
import com.estancias.ejercicio.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> getall(){
        return ResponseEntity.ok(usuarioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        if(usuario.getId()==null|| !usuarioService.existePorId(usuario.getId())){
            return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario){
        if(usuario.getId()!= null && usuarioService.existePorId(usuario.getId())){
            return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> borrarUsuario(Long id){
        if(usuarioService.existePorId(id)){
            usuarioService.BorrarPorId(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
