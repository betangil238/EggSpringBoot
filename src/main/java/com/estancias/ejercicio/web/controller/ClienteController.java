package com.estancias.ejercicio.web.controller;

import com.estancias.ejercicio.Persistence.entity.Cliente;
import com.estancias.ejercicio.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodosClientes(){
        return ResponseEntity.ok(clienteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClienteId(@PathVariable("id") Long id){
        return ResponseEntity.ok(clienteService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){
        if(cliente.getId()==null || !clienteService.existePorId(cliente.getId())){
            return ResponseEntity.ok(clienteService.guardarUsuario(cliente));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente){
        if(cliente.getId()!=null && clienteService.existePorId(cliente.getId())){
            return ResponseEntity.ok(clienteService.guardarUsuario(cliente));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarCliente(Long id){
        if(clienteService.existePorId(id)){
            clienteService.BorrarPorId(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
