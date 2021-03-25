package com.example.observable_crud_demo.service;

import com.example.observable_crud_demo.domain.PersonModel;
import com.example.observable_crud_demo.dto.PersonDto;
import com.example.observable_crud_demo.mapper.PersonMapper;
import com.example.observable_crud_demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonImplService implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<PersonModel> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Optional<PersonModel> findByIdIfExist(PersonDto personDto) {
        return personRepository.findById(personDto.getId());
    }

    @Override
    public PersonModel savePerson(PersonDto personDto) {
        var personModel = personMapper.fromCreatePersonDtoToPersonEntitySave(personDto);
        return personRepository.save(personModel);
    }

    @Override
    public PersonModel updatePerson(PersonDto personDto) {
        var personModel = personMapper.fromCreatePersonDtoToPersonEntityUpdate(personDto);
        return personRepository.save(personModel);
    }

    @Override
    public Long deletePerson(Long id) {

        personRepository.deleteById(id);
        return id;
    }
}
