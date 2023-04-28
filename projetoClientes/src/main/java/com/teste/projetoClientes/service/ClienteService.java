package com.teste.projetoClientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.projetoClientes.model.Cliente;
import com.teste.projetoClientes.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findByCpfCnpj(String cpfCnpj) {
        return clienteRepository.findByCpfCnpj(cpfCnpj);
    }

    public Cliente save(Cliente cliente) {
    	if(cliente.getTipo().equals("pessoa_fisica")) {
    		cliente.setTipo("Pessoa Física");
    	}else {
    		cliente.setTipo("Pessoa Jurídica");
    	}
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    
}