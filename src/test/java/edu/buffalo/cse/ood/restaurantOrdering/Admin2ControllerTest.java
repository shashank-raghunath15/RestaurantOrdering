package edu.buffalo.cse.ood.restaurantOrdering;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.buffalo.cse.ood.restaurantOrdering.controller.AdminController;
import edu.buffalo.cse.ood.restaurantOrdering.controller.Controller;
import edu.buffalo.cse.ood.restaurantOrdering.service.AdminService;
import edu.buffalo.cse.ood.restaurantOrdering.service.impl.ServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminController.class, secure = false)
public class Admin2ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private Controller controller;

	@MockBean
	private ServiceImpl serviceImpl;

	@MockBean
	private AdminService adminService;

	@Test
	public void dummyTest() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
	
	/*	Mockito.when(adminService.getAllAdmins()).thenReturn(admins);
		RequestBuilder builder = MockMvcRequestBuilders.get("/admin/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = (MvcResult) mockMvc.perform(builder).andReturn();
		System.out.println(result.getResponse().getContentAsString());*/

	}
}
