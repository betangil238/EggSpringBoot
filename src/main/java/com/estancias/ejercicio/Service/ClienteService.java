package com.estancias.ejercicio.Service;

import com.estancias.ejercicio.Persistence.entity.Cliente;
import com.estancias.ejercicio.Persistence.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente guardarUsuario(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerTodos(){
        return this.clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Long id){
        return this.clienteRepository.findById(id).orElse(null);
    }

    public void BorrarPorId(long id){
        this.clienteRepository.deleteById(id);
    }

    public boolean existePorId(long id){
        return this.clienteRepository.existsById(id);
    }
}
