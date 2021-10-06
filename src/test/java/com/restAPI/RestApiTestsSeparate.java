package com.restAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestApiTestsSeparate {

	@Autowired
	private MockMvc request;

	@Test
	void responseDefault() throws Exception {
		this.request.perform(get("/resource")).andDo(print()).andExpect(status().isInternalServerError());
	}

	@Test
	void responseUserWithId() throws Exception {
		String content =
				this.request.perform(get("/resource")).andDo(print()).andExpect(status().isInternalServerError())
						.andReturn().getResponse().getContentAsString();
		System.out.println("CONTENT: ");
		System.out.println(content);

		Assert.hasText(content, "{ 1 Welcome, Tom, Ryan!}");

//		this.request.perform(get("/resource?userId=4")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().string("{ 1 Welcome, Tom, Ryan!}"));
	}

	@Test
	void visits() throws Exception {
		this.request.perform(get("/resource?userId=4")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("{ 1 Welcome, Tom, Ryan!}"));

		this.request.perform(get("/visits")).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value("4"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].count").value("1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Tom"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value("Ryan"));
	}
}
