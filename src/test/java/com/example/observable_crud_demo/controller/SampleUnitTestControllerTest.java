package com.example.observable_crud_demo.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleUnitTestController.class)
@WithMockUser
class SampleUnitTestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloExpected() {
        /*Low Level Approach*/
        String tea = "TeaTea";
        SampleUnitTestController controller = new SampleUnitTestController();

        Assert.assertEquals(tea, controller.hello());
    }

    @Test
    public void getHello() throws Exception {
        /*Native Unit test*/
        mockMvc.perform(get("/hello"))
                .andExpect(status().isUnauthorized());
    }
}