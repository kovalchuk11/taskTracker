package com.kovalchuk.tasktracker;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TaskTrackerApplicationTests {
	private static final String TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb21lbmFtZSIsImF1dGhvcml0aWVzIjpbXSwiaWF0IjoxNTkzMzgxMDk4LCJleHAiOjE1OTQyNDIwMDB9._asws-FmJR2x3eHZ8W7VeBI651Me824FJtfrk1S4nzJybGwogdcIKOtXbh8mSf4rf2cz8sB8Y2T_S0mLgQ1v2w";


	private MockMvc mvc;

	@Autowired
	TaskTrackerApplicationTests(MockMvc mvc) {
		this.mvc = mvc;
	}

	@Test
	public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/api/user/getUsers")).andExpect(status().isForbidden());
	}

	@Test
	public void shouldAllowAccessWithToken() throws Exception {
		String body = "{\n" +
				"    \"page\": 1\n" +
				"}";

		mvc.perform(MockMvcRequestBuilders.post("https://nameless-falls-13226.herokuapp.com/api/user/getUsers")
				.content(body).contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", TOKEN))
				.andExpect(status().isOk());
	}

}
