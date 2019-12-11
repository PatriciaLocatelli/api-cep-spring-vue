package edu.ifrs.poa.projetofinal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.ifrs.poa.projetofinal.dto.CepDto;

@Service
public class CepService {

    public CepDto consultar(String cep) {
        try {
            String url = String.format("https://viacep.com.br/ws/%s/json/", cep);
            RestTemplate request = new RestTemplate();
            CepDto dto = request.getForObject(url, CepDto.class);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao encontrar o CEP", e);
        }
    }

}