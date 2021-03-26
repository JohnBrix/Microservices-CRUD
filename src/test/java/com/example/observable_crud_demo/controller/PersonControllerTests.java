package com.example.observable_crud_demo.controller;

import com.example.observable_crud_demo.domain.PersonModel;
import com.example.observable_crud_demo.dto.PersonDto;
import com.example.observable_crud_demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*@ComponentScan(basePackages = {"com.example.observable_crud_demo.service"})
@EnableJpaRepositories("com.example.observable_crud_demo.repository")*/
@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonController.class)
@WithMockUser
public class PersonControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    @MockBean
    private PersonService personService;

    @Test
    public void getPersonExpect204() throws Exception {
        mockMvc.perform(get("/api/person")).andExpect(status().isNoContent())
                .andExpect(content().contentType("text/plain;charset=UTF-8"));
    }

    @Test
    public void getPersonExpect200() throws Exception {
        var cal = Calendar.getInstance();
        cal.set(1999, Calendar.FEBRUARY, 17);

        var dto = new PersonDto();
        dto.setId((long) 5);
        dto.setFirstName("UnitTest");
        dto.setLastName("UnitTest");
        dto.setAge(1);
        dto.setBirthDate(cal.getTime());
        dto.setAddress("dadda");
        dto.setDateCreated(new Date(System.currentTimeMillis()));

        var model = new PersonModel();
        model.setId(dto.getId());
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setBirthDate(dto.getBirthDate());
        model.setAge(dto.getAge());
        model.setAddress(dto.getAddress());
        model.setDateCreated(new Date(System.currentTimeMillis()));

        var list = new ArrayList<PersonModel>();
        list.add(model);

        Mockito.when(
                personService.findAll()).thenReturn(list);

        mockMvc.perform(get("/api/person")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        assertThat(status().isOk());
    }

    @Test
    public void savePersonExpect200() throws Exception {
        var json = "{\"firstName\":\"insert\",\"birthDate\":\"1999-02-17\",\"age\":\"21\",\"address\":\"Caloocan City\",\"dateCreated\":\"2021-03-26\"}";

        var requestBuilder = MockMvcRequestBuilders
                .post("/api/person")
                .accept(MediaType.APPLICATION_JSON).content(json) //in order to trigger the json
                .contentType(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(requestBuilder).andReturn();
        var response = result.getResponse();
        //expected output
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void updatePersonExpect200() throws Exception {
        var json = "{\"id\":\"1\",\"firstName\":\"unit\",\"birthDate\":\"1999-02-17\",\"age\":\"21\",\"address\":\"Caloocan City\",\"dateCreated\":\"2021-03-26\"}";

        var requestBuilder = MockMvcRequestBuilders
                .put("/api/person")
                .accept(MediaType.APPLICATION_JSON).content(json) //in order to trigger the requestBody
                .contentType(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(requestBuilder).andReturn();
        var response = result.getResponse();
        //expected output
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test
    public void deletePersonExpect200() throws Exception {
        var requestBuilder = MockMvcRequestBuilders
                .delete("/api/person?id=1")
                .accept(MediaType.APPLICATION_JSON) //in order to trigger the requestBody
                .contentType(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(requestBuilder).andReturn();
        var response = result.getResponse();
        //expected output
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

}
