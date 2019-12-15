package edu.ifrs.poa.projetofinal.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import edu.ifrs.poa.projetofinal.dto.CepDto;

@SpringBootTest
public class CepServiceTest {
    
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CepService service;
    
    @Test
    public void consultarCepTest() {
        
        CepDto dto = new CepDto();
        
        dto.setCep("13405106");
        dto.setLogradouro("Rua das Siriemas");
        dto.setComplemento("Lado Par");
        dto.setBairro("Nova Piracicaba");
        dto.setLocalidade("Piracicaba");
        dto.setUf("SP"); 
        
        Mockito
            .when(restTemplate.getForObject("https://viacep.com.br/ws/13405106/json/", CepDto.class))
            .thenReturn(dto); 

        CepDto retornoCep = service.consultar("13405106");
        Assert.assertEquals("13405106", retornoCep.getCep());
        Assert.assertEquals("Rua das Siriemas", retornoCep.getLogradouro());
        Assert.assertEquals("Lado Par", retornoCep.getComplemento());
        Assert.assertEquals("Nova Piracicaba", retornoCep.getBairro());
        Assert.assertEquals("Piracicaba", retornoCep.getLocalidade());
        Assert.assertEquals("SP", retornoCep.getUf());
    }

}