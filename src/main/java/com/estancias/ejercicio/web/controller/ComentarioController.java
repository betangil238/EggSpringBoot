package com.estancias.ejercicio.web.controller;

import com.estancias.ejercicio.Persistence.entity.Comentario;
import com.estancias.ejercicio.Service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Comentario")
public class ComentarioController {
    private final ComentarioService comentarioService;
    @Autowired
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> obtenerTodosComentarios(){
        return ResponseEntity.ok(comentarioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerComentarioId(@PathVariable("id") Long id){
        return ResponseEntity.ok(comentarioService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Comentario> guardarComentario(@RequestBody Comentario comentario){
        if(comentario.getId()==null || !comentarioService.existePorId(comentario.getId())){
            return ResponseEntity.ok(comentarioService.guardarComentario(comentario));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping ResponseEntity<Comentario> actualizarComentario(@RequestBody Comentario comentario){
        if(comentario.getId()!=null && comentarioService.existePorId(comentario.getId())){
            return ResponseEntity.ok(comentarioService.guardarComentario(comentario));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarComentario(Long id){
        if(comentarioService.existePorId(id)){
            comentarioService.BorrarPorId(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
