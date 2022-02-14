package com.akadow.prototype001.controller;

import com.akadow.prototype001.service.DummyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(Thymeleaf.class)
public class ThymeleafTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    DummyService dummyService;

    @Test
    public void sample() throws Exception {
        System.out.println("## dummyService.createThymeleaf() : " + dummyService.createThymeleaf());//TODO: service value is null

        mockMvc.perform(MockMvcRequestBuilders.get("/page/sample"))
                .andExpect(status().isOk())
                .andExpect(view().name("sample"))
                .andExpect(model().attribute("name", dummyService.createThymeleaf().get("name")))
                .andDo(print());
    }
}
