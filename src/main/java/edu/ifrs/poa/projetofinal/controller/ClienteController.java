package edu.ifrs.poa.projetofinal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifrs.poa.projetofinal.entity.Cliente;
import edu.ifrs.poa.projetofinal.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return service.adicionar(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Cliente consultar(@PathVariable("id") Long id) {
        return service.consultar(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        return service.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id) {
        service.apagar(id);
    }
}