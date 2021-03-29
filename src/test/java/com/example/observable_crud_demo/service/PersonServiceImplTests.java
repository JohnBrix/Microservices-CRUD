package com.example.observable_crud_demo.service;

import com.example.observable_crud_demo.domain.PersonModel;
import com.example.observable_crud_demo.dto.PersonDto;
import com.example.observable_crud_demo.mapper.PersonMapper;
import com.example.observable_crud_demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonServiceImplTests {


    @Autowired
    @Mock
    private PersonRepository personRepository;

    @Test
    public void testGetPersons() {
        List<PersonModel> products = personRepository.findAll();
        assertThat(products).size().isGreaterThan(0);
    }
    @Test
    public void testFindById(){
        Integer id = 1;
        Optional<PersonModel> products = personRepository.findById(id);
        assertThat(status().isOk());
    }

    @Test
    /*@Rollback(false)*/
    public void testSave() {
        PersonMapper personMapper = new PersonMapper();
        Calendar cal = Calendar.getInstance();
        cal.set(1999, Calendar.FEBRUARY, 17);

        PersonDto dto = new PersonDto();
        dto.setFirstName("UnitTest");
        dto.setLastName("UnitTest");
        dto.setAge(1);
        dto.setBirthDate(cal.getTime());
        dto.setAddress("Estancia Iloilo");
        dto.setDateCreated(new Date(System.currentTimeMillis()));

        PersonModel model = personMapper.fromCreatePersonDtoToPersonEntitySave(dto);

        PersonModel repo = personRepository.save(model);

        assertThat(repo.getId()).isGreaterThan(0);
    }

    @Test
    /*@Rollback(false)*/
    public void testUpdatePerson() {
        PersonMapper personMapper = new PersonMapper();
        Calendar cal = Calendar.getInstance();
        cal.set(1999, Calendar.FEBRUARY, 17);

        PersonDto dto = new PersonDto();
        dto.setId(5);
        dto.setFirstName("UnitTest");
        dto.setLastName("UnitTest");
        dto.setAge(1);
        dto.setBirthDate(cal.getTime());
        dto.setAddress("Estancia Iloilo");
        dto.setDateCreated(new Date(System.currentTimeMillis()));

        PersonModel model = personMapper.fromCreatePersonDtoToPersonEntityUpdate(dto);

        PersonModel repo = personRepository.save(model);

        assertThat(repo.getId()).isGreaterThan(0);
    }

    @Test
    public void testDeletePerson() {
        personRepository.deleteById( 1);
        Optional<PersonModel> find = personRepository.findById( 1);
        assertThat(find).isEmpty();
    }
}
