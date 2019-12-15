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

    private void formatarDados(Cliente cliente) {
        cliente.setNome(cliente.getNome().toUpperCase());
        cliente.setLogradouro(cliente.getLogradouro().toUpperCase());
        cliente.setBairro(cliente.getBairro().toUpperCase());
        cliente.setUf(cliente.getUf().toUpperCase());
        cliente.setLocalidade(cliente.getLocalidade().toUpperCase());
        cliente.setComplemento(cliente.getComplemento().toUpperCase());
        cliente.setEmail(cliente.getEmail().toLowerCase());
    }

    public Cliente adicionar(Cliente cliente) {
        formatarDados(cliente);
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
        formatarDados(cliente);
        return repository.save(cliente);
    }

    public void apagar(Long id){
        if(! repository.existsById(id)){
            throw new RuntimeException("Não achei");
        }
        repository.deleteById(id);
    }
}