package com.example.observable_crud_demo.service;

import com.example.observable_crud_demo.domain.PersonModel;
import com.example.observable_crud_demo.dto.PersonDto;
import com.example.observable_crud_demo.mapper.PersonMapper;
import com.example.observable_crud_demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<PersonModel> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<PersonModel> findById(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public PersonModel save(PersonDto personDto) {
        var personModel = personMapper.fromCreatePersonDtoToPersonEntitySave(personDto);
        return personRepository.save(personModel);
    }

    @Override
    public PersonModel updatePerson(PersonDto personDto) {
        var personModel = personMapper.fromCreatePersonDtoToPersonEntityUpdate(personDto);
        return personRepository.save(personModel);
    }

    @Override
    public Integer deleteById(Integer id) {

        personRepository.deleteById(id);
        return id;
    }
}
