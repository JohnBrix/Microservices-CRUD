package com.example.observable_crud_demo.service;

import com.example.observable_crud_demo.domain.PersonModel;
import com.example.observable_crud_demo.dto.PersonDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    PersonModel save(PersonDto personDto);

    PersonModel updatePerson(PersonDto personDto);

    Optional<PersonModel> findById(Integer id);

    List<PersonModel> findAll();

    Integer deleteById(Integer id);

}
