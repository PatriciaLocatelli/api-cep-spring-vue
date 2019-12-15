package edu.ifrs.poa.projetofinal.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ifrs.poa.projetofinal.entity.Cliente;
import edu.ifrs.poa.projetofinal.repository.ClienteRepository;

@SpringBootTest
public class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    @Test
    public void adicionarClienteTest() {

        Cliente cliente = new Cliente();

        cliente.setNome("Lucca Theo Moura");
        cliente.setTelefone("988284985");
        cliente.setEmail("LUCCATHEOMOURA-92@DILLON.COM.BR");
        cliente.setCep("13405106");
        cliente.setLogradouro("Rua das Siriemas");
        cliente.setNumero("921");
        cliente.setComplemento("Lado Par");
        cliente.setBairro("Nova Piracicaba");
        cliente.setLocalidade("Piracicaba");
        cliente.setUf("sp");

        Mockito.when(repository.save(cliente)).thenReturn(cliente);

        Cliente retornoCliente = service.adicionar(cliente);
        Assert.assertEquals("LUCCA THEO MOURA", retornoCliente.getNome());
        Assert.assertEquals("988284985", retornoCliente.getTelefone());
        Assert.assertEquals("luccatheomoura-92@dillon.com.br", retornoCliente.getEmail());
        Assert.assertEquals("13405106", retornoCliente.getCep());
        Assert.assertEquals("RUA DAS SIRIEMAS", retornoCliente.getLogradouro());
        Assert.assertEquals("921", retornoCliente.getNumero());
        Assert.assertEquals("LADO PAR", retornoCliente.getComplemento());
        Assert.assertEquals("NOVA PIRACICABA", retornoCliente.getBairro());
        Assert.assertEquals("PIRACICABA", retornoCliente.getLocalidade());
        Assert.assertEquals("SP", retornoCliente.getUf());
    }

    @Test
    public void atualizarClienteTest() {

        Cliente cliente = new Cliente();

        cliente.setId(1L);
        cliente.setNome("Lucca Theo Moura");
        cliente.setTelefone("988284985");
        cliente.setEmail("LUCCATHEOMOURA-92@DILLON.COM.BR");
        cliente.setCep("13405106");
        cliente.setLogradouro("Rua das Siriemas");
        cliente.setNumero("921");
        cliente.setComplemento("Lado Par");
        cliente.setBairro("Nova Piracicaba");
        cliente.setLocalidade("Piracicaba");
        cliente.setUf("sp");

        Mockito.when(repository.save(cliente)).thenReturn(cliente);
        Mockito.when(repository.existsById(1L)).thenReturn(true);

        Cliente retornoCliente = service.atualizar(1L, cliente);

        Assert.assertTrue(1L == retornoCliente.getId());
        Assert.assertEquals("LUCCA THEO MOURA", retornoCliente.getNome());
        Assert.assertEquals("988284985", retornoCliente.getTelefone());
        Assert.assertEquals("luccatheomoura-92@dillon.com.br", retornoCliente.getEmail());
        Assert.assertEquals("13405106", retornoCliente.getCep());
        Assert.assertEquals("RUA DAS SIRIEMAS", retornoCliente.getLogradouro());
        Assert.assertEquals("921", retornoCliente.getNumero());
        Assert.assertEquals("LADO PAR", retornoCliente.getComplemento());
        Assert.assertEquals("NOVA PIRACICABA", retornoCliente.getBairro());
        Assert.assertEquals("PIRACICABA", retornoCliente.getLocalidade());
        Assert.assertEquals("SP", retornoCliente.getUf());
    }
}