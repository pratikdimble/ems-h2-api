package com.cd.controller;

import com.cd.repository.EmsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional // Ensures database is rolled back after each test
class EmsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private EmsRepository emsRepository;

    // Clear the repository before each test
    @BeforeEach
    void clearRepository() {
        emsRepository.deleteAll();
    }
    @Test
    void testAddTodo_Success() throws Exception {
        mockMvc.perform(post("/ems")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "name": "Pratik",
                                  "age": 25,
                                  "address": "NH4 Katraj Pune",
                                  "designation": "Jr Dev",
                                  "department": "DU1",
                                  "joiningDate": "2024-11-29",
                                  "title": "TestTask",
                                  "task": "This is a test task description."
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.employeeId").exists())
                .andExpect(jsonPath("$.name").value("Pratik"))
                .andExpect(jsonPath("$.age").value(25))
                .andExpect(jsonPath("$.designation").value("Jr Dev"))
                .andExpect(jsonPath("$.department").value("DU1"))
                .andExpect(jsonPath("$.title").value("TestTask"))
                .andExpect(jsonPath("$.task").value("This is a test task description."))
        ;
    }

}
