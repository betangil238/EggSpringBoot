package com.estancias.ejercicio.web.controller;

import com.estancias.ejercicio.Persistence.entity.Casa;
import com.estancias.ejercicio.Service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Casa")
public class CasaController {
    private final CasaService casaService;
    @Autowired
    public CasaController(CasaService casaService) {
        this.casaService = casaService;
    }
    @GetMapping
    public ResponseEntity<List<Casa>> obtenerTodasCasas(){
        return ResponseEntity.ok(casaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Casa> obtenerCasaId(@PathVariable("id") Long id){
        return ResponseEntity.ok(casaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Casa> guardarCasa(@RequestBody Casa casa){
        if(casa.getId()==null || !casaService.existePorId(casa.getId())){
            return ResponseEntity.ok(casaService.guardarUsuario(casa));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping ResponseEntity<Casa> actualizarCasa(@RequestBody Casa casa){
        if(casa.getId()!=null && casaService.existePorId(casa.getId())){
            return ResponseEntity.ok(casaService.guardarUsuario(casa));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarCasa(Long id){
        if(casaService.existePorId(id)){
            casaService.BorrarPorId(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
