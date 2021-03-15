package com.bae.shelter.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.shelter.domain.ShelterAnimal;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:shelteranimal-schema.sql",
		"classpath:shelteranimal-dat.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ShelterAnimalControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testcreate() throws Exception {

		ShelterAnimal newShelterAnimal = new ShelterAnimal("Dog", "Archie", 4, "Cockapoo", "Male", "Medium",
				"East Riding of Yorkshire", "no additional information", null);

		String newShelterAnimalAsJSON = this.mapper.writeValueAsString(newShelterAnimal);

		RequestBuilder mockRequest = post("/createShelterAnimal").contentType(MediaType.APPLICATION_JSON)
				.content(newShelterAnimalAsJSON);

		ShelterAnimal savedShelterAnimal = new ShelterAnimal(1L, "Dog", "Archie", 4, "Cockapoo", "Male", "Medium",
				"East Riding of Yorkshire", "no additional information", null);

		String savedShelterAnimalAsJSON = this.mapper.writeValueAsString(savedShelterAnimal);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedShelterAnimalAsJSON);

		this.mockMvc.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void updateTest() throws Exception {

		ShelterAnimal newShelterAnimal = new ShelterAnimal("Dog", "Archie", 4, "Cockapoo", "Male", "Medium",
				"East Riding of Yorkshire", "no additional information", null);

		String newShelterAnimalAsJSON = this.mapper.writeValueAsString(newShelterAnimal);

		RequestBuilder mockRequest = put("/updateShelterAnimal/1").contentType(MediaType.APPLICATION_JSON)
				.content(newShelterAnimalAsJSON);

		ShelterAnimal savedShelterAnimal = new ShelterAnimal(1L, "Dog", "Archie", 4, "Cockapoo", "Male", "Medium",
				"East Riding of Yorkshire", "no additional information", null);

		String savedShelterAnimalAsJSON = this.mapper.writeValueAsString(savedShelterAnimal);

		ResultMatcher matchStatus = status().isOk();

		ResultMatcher matchbody = content().json(savedShelterAnimalAsJSON);

		this.mockMvc.perform(mockRequest).andExpect(matchStatus).andExpect(matchbody);
	}

	@Test
	void deleteTest() throws Exception {

		RequestBuilder mockRequest = delete("/removeShelterAnimal/1");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().string("true");

		this.mockMvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

	}
}
