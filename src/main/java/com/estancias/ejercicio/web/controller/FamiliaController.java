package com.estancias.ejercicio.web.controller;


import com.estancias.ejercicio.Persistence.entity.Familia;
import com.estancias.ejercicio.Service.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Familia")
public class FamiliaController {
    private final FamiliaService familiaService;
    @Autowired
    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @GetMapping
    public ResponseEntity<List<Familia>> obtenerTodaFamilia(){
        return ResponseEntity.ok(familiaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Familia> obtenerFamiliaId(@PathVariable("id") Long id){
            return ResponseEntity.ok(familiaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Familia> guardarFamilia(@RequestBody Familia familia){
        if(familia.getId()==null || !familiaService.existePorId(familia.getId())){
            return ResponseEntity.ok(familiaService.guardarFamilia(familia));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping ResponseEntity<Familia> actualizarFamilia(@RequestBody Familia familia){
        if(familia.getId()!=null && familiaService.existePorId(familia.getId())){
            return ResponseEntity.ok(familiaService.guardarFamilia(familia));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarFamilia(Long id){
        if(familiaService.existePorId(id)){
            familiaService.BorrarPorId(id);
            return ResponseEntity.ok().build();
        }
            return ResponseEntity.badRequest().build();
    }
}
