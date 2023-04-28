package com.teste.projetoClientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.projetoClientes.model.Cliente;
import com.teste.projetoClientes.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{cpfCnpj}")
    public ResponseEntity<Cliente> findByCpfCnpj(@PathVariable String cpfCnpj) {
        Cliente cliente = clienteService.findByCpfCnpj(cpfCnpj);
        if (cliente != null) {
            cliente.setTipo(cliente.getTipo().equals("Pessoa Física") ? "pessoa_fisica" : "pessoa_juridica");
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterarCliente(@PathVariable String id, @RequestBody Cliente cliente) {
  
        Cliente clienteExistente = clienteService.findByCpfCnpj(id);
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setTipo(cliente.getTipo());
        clienteExistente.setCpfCnpj(cliente.getCpfCnpj());
        clienteExistente.setRgIe(cliente.getRgIe());
        clienteExistente.setTelefones(cliente.getTelefones());
        clienteExistente.setAtivo(cliente.isAtivo());
        clienteService.save(clienteExistente);
        return ResponseEntity.ok(clienteExistente);
    }
}