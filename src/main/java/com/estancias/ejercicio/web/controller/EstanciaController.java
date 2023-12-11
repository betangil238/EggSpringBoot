package com.estancias.ejercicio.web.controller;

import com.estancias.ejercicio.Persistence.entity.Estancia;
import com.estancias.ejercicio.Service.EstanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Estancia")
public class EstanciaController {
    private final EstanciaService estanciaService;
    @Autowired
    public EstanciaController(EstanciaService estanciaService) {
        this.estanciaService = estanciaService;
    }

    @GetMapping
    public ResponseEntity<List<Estancia>> obtenerTodasEstancias(){
        return ResponseEntity.ok(estanciaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estancia> obtenerEstanciaId(@PathVariable("id") Long id){
        return ResponseEntity.ok(estanciaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Estancia> guardarEstancia(@RequestBody Estancia estancia){
        if(estancia.getId()==null || !estanciaService.existePorId(estancia.getId())){
            return ResponseEntity.ok(estanciaService.guardarEstancia(estancia));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping ResponseEntity<Estancia> actualizarEstancia(@RequestBody Estancia estancia){
        if(estancia.getId()!=null && estanciaService.existePorId(estancia.getId())){
            return ResponseEntity.ok(estanciaService.guardarEstancia(estancia));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarEstancia(Long id){
        if(estanciaService.existePorId(id)){
            estanciaService.BorrarPorId(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
