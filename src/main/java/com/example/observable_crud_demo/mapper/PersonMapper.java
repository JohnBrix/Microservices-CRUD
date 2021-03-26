package com.example.observable_crud_demo.mapper;

import com.example.observable_crud_demo.domain.PersonModel;
import com.example.observable_crud_demo.dto.PersonDto;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PersonMapper {


    public PersonModel fromCreatePersonDtoToPersonEntitySave(PersonDto createPersonDto) {
        var personModel = new PersonModel();
        personModel.setFirstName(createPersonDto.getFirstName());
        personModel.setLastName(createPersonDto.getLastName());
        personModel.setBirthDate(createPersonDto.getBirthDate());
        personModel.setAge(createPersonDto.getAge());
        personModel.setAddress(createPersonDto.getAddress());
        personModel.setDateCreated(new Date(System.currentTimeMillis()));

        return personModel;
    }
    public PersonModel fromCreatePersonDtoToPersonEntityUpdate(PersonDto createPersonDto) {
        var personModel = new PersonModel();
/*        personModel.setId(createPersonDto.getId());*/
        personModel.setFirstName(createPersonDto.getFirstName());
        personModel.setLastName(createPersonDto.getLastName());
        personModel.setBirthDate(createPersonDto.getBirthDate());
        personModel.setAge(createPersonDto.getAge());
        personModel.setAddress(createPersonDto.getAddress());
        personModel.setDateCreated(new Date(System.currentTimeMillis()));

        return personModel;
    }
}
