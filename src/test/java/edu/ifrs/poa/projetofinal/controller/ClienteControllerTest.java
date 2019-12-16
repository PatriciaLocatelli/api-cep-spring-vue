package edu.ifrs.poa.projetofinal.controller;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.ifrs.poa.projetofinal.ApiTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ClienteControllerTest extends ApiTest {

    @Test
    public void consultarClienteTest() {
        RestAssured
            .given()
                .request()
                .header("Accept", ContentType.JSON)
            .when()
                .get("/clientes/100")
            .then()
                .log().body()
                .statusCode(200)
                .body(
                    "id", Matchers.equalTo(100),
                    "nome", Matchers.equalTo("Patricia"),
                    "telefone", Matchers.equalTo("5122334455"),
                    "email", Matchers.equalTo("teste@teste.com.br"),
                    "cep",Matchers.equalTo("01001001"),
                    "logradouro", Matchers.equalTo("Praça da Sé"),
                    "complemento", Matchers.equalTo("lado par"),
                    "numero", Matchers.equalTo("123"),
                    "bairro", Matchers.equalTo("Sé"),
                    "localidade", Matchers.equalTo("São Paulo"),
                    "uf", Matchers.equalTo("SP")
                );
    }

    @Test
    public void cadastrarClienteTest() {
        Map<String, Object> parametros = new HashMap<>();
        
        parametros.put("nome", "Sueli Letícia Agatha Castro");
        parametros.put("telefone", "992144924");
        parametros.put("email", "SUELILETICIAAGATHACASTRO_@VEGACON.COM.BR");
        parametros.put("cep", "29157625");
        parametros.put("logradouro", "Rua Projetada 2");
        parametros.put("complemento", "lado par");
        parametros.put("numero", "811");
        parametros.put("bairro", "Alice Coutinho");
        parametros.put("localidade", "Cariacica");
        parametros.put("uf", "es");

        RestAssured
            .given()
                .request()
                .header("Accept", ContentType.JSON)
                .header("Content-type", ContentType.JSON)
                .body(parametros)
            .when()
                .post("/clientes")
            .then()
                .log().body()
                .statusCode(200)
                .body(
                    "id", Matchers.instanceOf(Integer.class),
                    "nome", Matchers.equalTo("SUELI LETÍCIA AGATHA CASTRO"),
                    "telefone", Matchers.equalTo("992144924"),
                    "email", Matchers.equalTo("suelileticiaagathacastro_@vegacon.com.br"),
                    "cep",Matchers.equalTo("29157625"),
                    "logradouro", Matchers.equalTo("RUA PROJETADA 2"),
                    "complemento", Matchers.equalTo("LADO PAR"),
                    "numero", Matchers.equalTo("811"),
                    "bairro", Matchers.equalTo("ALICE COUTINHO"),
                    "localidade", Matchers.equalTo("CARIACICA"),
                    "uf", Matchers.equalTo("ES")
                );
    }

    @Test
    public void atualizarClienteTest() {
        Map<String, Object> parametros = new HashMap<>();
        
        parametros.put("id", "100");
        parametros.put("nome", "Renato Giovanni Bruno Jesus");
        parametros.put("telefone", "992602544");
        parametros.put("email", "RENATOGIOVANNIBRUNOJESUS_@IPK.ORG.BR");
        parametros.put("cep", "64090070");
        parametros.put("logradouro", "Rua Uruçuí");
        parametros.put("complemento", "lado par");
        parametros.put("numero", "197");
        parametros.put("bairro", "Gurupi");
        parametros.put("localidade", "Teresina");
        parametros.put("uf", "pi");

        RestAssured
            .given()
                .request()
                .header("Accept", ContentType.JSON)
                .header("Content-type", ContentType.JSON)
                .body(parametros)
            .when()
                .put("/clientes/100")
            .then()
                .log().body()
                .statusCode(200)
                .body(
                    "id", Matchers.instanceOf(Integer.class),
                    "nome", Matchers.equalTo("RENATO GIOVANNI BRUNO JESUS"),
                    "telefone", Matchers.equalTo("992602544"),
                    "email", Matchers.equalTo("renatogiovannibrunojesus_@ipk.org.br"),
                    "cep",Matchers.equalTo("64090070"),
                    "logradouro", Matchers.equalTo("RUA URUÇUÍ"),
                    "complemento", Matchers.equalTo("LADO PAR"),
                    "numero", Matchers.equalTo("197"),
                    "bairro", Matchers.equalTo("GURUPI"),
                    "localidade", Matchers.equalTo("TERESINA"),
                    "uf", Matchers.equalTo("PI")
                );
    }

    @Test
    public void apagarClienteTest() {
        RestAssured
            .given()
                .request()
                .header("Accept", ContentType.JSON)
            .when()
                .delete("/clientes/100")
            .then()
                .statusCode(200);
    }

    @Test
    public void listarClienteTest() {
        RestAssured
            .given()
                .request()
                .header("Accept", ContentType.JSON)
            .when()
                .get("/clientes")
            .then()
                .log().body()
                .statusCode(200);
    }

}