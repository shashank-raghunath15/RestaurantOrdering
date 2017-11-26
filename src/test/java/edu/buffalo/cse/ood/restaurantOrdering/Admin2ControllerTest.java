package edu.buffalo.cse.ood.restaurantOrdering;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.buffalo.cse.ood.restaurantOrdering.controller.AdminController;
import edu.buffalo.cse.ood.restaurantOrdering.controller.Controller;
import edu.buffalo.cse.ood.restaurantOrdering.service.impl.ServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class Admin2ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private Controller controller;
	
	@MockBean
	private ServiceImpl serviceImpl;
	
	@Test
	public void dummyTest() throws Exception{
		RequestBuilder builder = MockMvcRequestBuilders.get("/admin/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = (MvcResult) mockMvc.perform(builder);
		
		System.out.println(result);
	}
}
