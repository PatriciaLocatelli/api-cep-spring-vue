package edu.ifrs.poa.projetofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ifrs.poa.projetofinal.entity.Cliente;
import edu.ifrs.poa.projetofinal.repository.ClienteRepository;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente adicionar(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente consultar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Não consegui consultar"));
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        if (! repository.existsById(id)) {
            throw new RuntimeException("Não achei");
        }
        return repository.save(cliente);
    }

    public void apagar(Long id){
        if(! repository.existsById(id)){
            throw new RuntimeException("Não achei");
        }
        repository.deleteById(id);
    }
}