package com.example.observable_crud_demo.controller;

import com.example.observable_crud_demo.dto.PersonDto;
import com.example.observable_crud_demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        var list = personService.getPersons();
        if (list.isEmpty()) {
            return new ResponseEntity("List is Empty", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(personService.getPersons(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody @Validated PersonDto personDto) {
        return new ResponseEntity(personService.savePerson(personDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updatePerson(@RequestBody @Valid PersonDto personDto) {
        var id = personService.findByIdIfExist(personDto);

        if (id.isPresent()) {
            return new ResponseEntity(personService.updatePerson(personDto), HttpStatus.OK);
        }
        return new ResponseEntity("Id cannot be empty or null", HttpStatus.BAD_REQUEST);
    }
    /*http://localhost:8081/api/person?id=1*/
    @DeleteMapping
    public ResponseEntity<Integer> deletePerson(@Valid @RequestParam("id") Long id) {
        var dto = new PersonDto();
        dto.setId(id);
        var dataId = personService.findByIdIfExist(dto);

        if (dataId.isPresent()) {

            return new ResponseEntity(personService.deletePerson(id), HttpStatus.OK);
        }
        return new ResponseEntity("Id not found", HttpStatus.NOT_FOUND);

    }
}
