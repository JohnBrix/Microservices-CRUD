package com.example.observable_crud_demo.controller;

import com.example.observable_crud_demo.dto.PersonDto;
import com.example.observable_crud_demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins = {"http://localhost:8081",}, maxAge = 3000)
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity getPersons() {
        var list = personService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity("List is Empty", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(personService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody PersonDto personDto) {
        return new ResponseEntity(personService.save(personDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updatePerson(@RequestBody PersonDto personDto) {
        return new ResponseEntity(personService.updatePerson(personDto), HttpStatus.OK);
    }

    /*http://localhost:8081/api/person?id=1*/
    @DeleteMapping
    public ResponseEntity<Integer> deletePerson(@Valid @RequestParam("id") Long id) {

        return new ResponseEntity(personService.deleteById(id), HttpStatus.OK);

    }
}
