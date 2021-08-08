package com.example.observable_crud_demo.controller;

import com.example.observable_crud_demo.dto.TestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SampleUnitTestController {

    @GetMapping("/hello")
    public Mono<ResponseEntity<TestDto>> hello(){
        System.out.println("Tangna mo bakla");
        TestDto dto = new TestDto();
        dto.setFirstName("John");
        dto.setLastName("Pomoy");

        return Mono.just(new ResponseEntity<>(dto, HttpStatus.OK));
    }
}
