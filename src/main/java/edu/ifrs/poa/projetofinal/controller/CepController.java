package edu.ifrs.poa.projetofinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifrs.poa.projetofinal.dto.CepDto;
import edu.ifrs.poa.projetofinal.service.CepService;

@RestController
@RequestMapping("/cep")
public class CepController{

    private CepService service;

    public CepController(CepService service) {
        this.service = service;
    }

    @GetMapping("/{cep}")
    public CepDto consultar(@PathVariable("cep") String cep) {
        return service.consultar(cep);
    }

}