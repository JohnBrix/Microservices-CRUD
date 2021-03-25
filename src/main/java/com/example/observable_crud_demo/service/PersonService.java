package com.example.observable_crud_demo.service;

import com.example.observable_crud_demo.domain.PersonModel;
import com.example.observable_crud_demo.dto.PersonDto;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    PersonModel savePerson(PersonDto personDto);
    PersonModel updatePerson(PersonDto personDto);
    Optional<PersonModel> findByIdIfExist(PersonDto personDto);
    List<PersonModel> getPersons();
    Long deletePerson(Long id);

}
