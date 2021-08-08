package com.example.observable_crud_demo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;


@ExtendWith(SpringExtension.class)
@WebFluxTest(SampleUnitTestController.class)
public class SampleUnitTestControllerWebFluxTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void modelTest() {
        webClient.get()
                .uri("/hello")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                /*json Path called getter from controller*/
                .jsonPath("$.firstName").isEqualTo("John")
                .jsonPath("$.lastName").isEqualTo("Pomoy");
    }
}