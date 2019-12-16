package edu.ifrs.poa.projetofinal.controller;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.ifrs.poa.projetofinal.ApiTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CepControllerTest extends ApiTest {

    @Test
    public void consultarCepTest() {
        RestAssured
            .given()
                .request()
                .header("Accept", ContentType.JSON)
            .when()
                .get("/cep/01001001")
            .then()
                .log().body()
                .statusCode(200)
                .body(
                    "logradouro", Matchers.equalTo("Praça da Sé"),
                    "cep", Matchers.equalTo("01001-001"),
                    "logradouro", Matchers.equalTo("Praça da Sé"),
                    "complemento", Matchers.equalTo("lado par"),
                    "bairro", Matchers.equalTo("Sé"),
                    "localidade", Matchers.equalTo("São Paulo"),
                    "uf", Matchers.equalTo("SP"),
                    "erro", Matchers.equalTo(false)
                );

    }

}