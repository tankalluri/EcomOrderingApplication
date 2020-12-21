package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.OrderController;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {
	
	private MockMvc mock;
	
	@InjectMocks
	private OrderController oc;
	
	@Before
	public void setUp() {
		mock = MockMvcBuilders.standaloneSetup(oc).build();
	}
	
	@Test
	public void testing() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/getOrderDetails")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
