package edu.buffalo.cse.ood.restaurantOrdering;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.buffalo.cse.ood.restaurantOrdering.controller.Controller;
import edu.buffalo.cse.ood.restaurantOrdering.controller.RestaurantController;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantOwnerService;
import edu.buffalo.cse.ood.restaurantOrdering.service.RestaurantService;
import edu.buffalo.cse.ood.restaurantOrdering.service.impl.ServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RestaurantController.class)
public class RestaurantControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
		
	@MockBean
	private Controller controller;
	
	@MockBean
	private ServiceImpl serviceImpl;
	
	@MockBean
	private RestaurantService restaurantService;
	
	@MockBean
	private RestaurantOwnerService ownerService;
	
	
	private static String RESTAURANT = "/restaurant/";
	
	@Test
	public void testGetAllRestaurants() throws Exception {
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setName("South Campus Cafe");
		restaurant1.setAddress("XYZ Street,Buffalo");
		RestaurantOwner owner1 = new RestaurantOwner();
		owner1.setName("ABCD");
		owner1.setPassword("ABCD");
		owner1.setUsername("ABCD");
		restaurant1.setOwner(owner1);
		
		Restaurant restaurant2 = new Restaurant();
		restaurant2.setName("North Campus Cafe");
		restaurant2.setAddress("ABC Street,Buffalo");
		RestaurantOwner owner2 = new RestaurantOwner();
		owner2.setName("XYZ");
		owner2.setPassword("XYZ");
		owner2.setUsername("XYZ");
		restaurant2.setOwner(owner2);
		
		List<Restaurant> restaurants = new ArrayList<>();
		restaurants.add(restaurant1);
		restaurants.add(restaurant2);
		
		for(Restaurant restaurant : restaurants) {
			restaurant.setOwner(ownerService.addRestaurantOwner(restaurant.getOwner()));
			restaurant = restaurantService.addRestaurant(restaurant);
		}
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(RESTAURANT).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(mvcResult.getResponse().getStatus(),HttpServletResponse.SC_OK);
		String expectedResponse = "";
		//copy this to expected response
		System.out.println(mvcResult.getResponse().getContentAsString());
		assertEquals(mvcResult.getResponse().getContentAsString(),expectedResponse);
		
		for(Restaurant restaurant: restaurants) {
			ownerService.deleteRestaurantOwner(restaurant.getOwner().getId());
			restaurantService.deleteRestaurant(restaurant.getId());
		}
	}
	
	@Test
	public void testGetRestaurant() throws Exception {
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setName("South Campus Cafe");
		restaurant1.setAddress("XYZ Street,Buffalo");
		RestaurantOwner owner1 = new RestaurantOwner();
		owner1.setName("ABCD");
		owner1.setPassword("ABCD");
		owner1.setUsername("ABCD");
		restaurant1.setOwner(owner1);
		restaurant1.setOwner(ownerService.addRestaurantOwner(restaurant1.getOwner()));
		restaurant1 = restaurantService.addRestaurant(restaurant1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(RESTAURANT + restaurant1.getId()).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		String expectedResponse = "";
		//copy this to expected response
		System.out.println(mvcResult.getResponse().getContentAsString());
		assertEquals(mvcResult.getResponse().getStatus(),HttpServletResponse.SC_OK);
		assertEquals(mvcResult.getResponse().getContentAsString(),expectedResponse);
		restaurantService.deleteRestaurant(restaurant1.getId());
	}
	
	@Test
	public void testAddRestaurant() throws Exception {
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setName("South Campus Cafe");
		restaurant1.setAddress("XYZ Street,Buffalo");
		RestaurantOwner owner1 = new RestaurantOwner();
		owner1.setName("ABCD");
		owner1.setPassword("ABCD");
		owner1.setUsername("ABCD");
		restaurant1.setOwner(owner1);
		restaurant1.setOwner(ownerService.addRestaurantOwner(restaurant1.getOwner()));
		ObjectMapper obj = new ObjectMapper();
		obj.writeValueAsString(restaurant1);
		String content = obj.writeValueAsString(restaurant1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(RESTAURANT).accept(MediaType.APPLICATION_JSON).content(content);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		List<Restaurant> restaurants = restaurantService.getAllRestaurants();
		boolean exists = false;
		Restaurant restaurantGet = null;
		for(Restaurant restaurant : restaurants) {
			if(restaurant.getName().equalsIgnoreCase(restaurant1.getName())) {
				exists = true;
				restaurantGet = restaurant;
				break;
			}
		}
		assertTrue(exists);
		restaurantService.deleteRestaurant(restaurantGet.getId());
	}
	
	/*@Test
	public void testUpdateRestaurant() throws Exception {
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setName("South Campus Cafe");
		restaurant1.setAddress("XYZ Street,Buffalo");
		RestaurantOwner owner1 = new RestaurantOwner();
		owner1.setName("ABCD");
		owner1.setPassword("ABCD");
		owner1.setUsername("ABCD");
		restaurant1.setOwner(owner1);
		restaurant1.setOwner(ownerService.addRestaurantOwner(restaurant1.getOwner()));
		restaurant1 = restaurantService.addRestaurant(restaurant1);
		String content = "{\"name\" : \"South Campus Cafeteria\" , \"address\" : \"XYZ "
				+ "Street,Buffalo\", \"ownerId\" :" + restaurant1.getOwner().getId()+ "}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(RESTAURANT).accept(MediaType.APPLICATION_JSON).content(content);
		mockMvc.perform(requestBuilder);
		Restaurant restaurantGet = restaurantService.getRestaurantById(restaurant1.getId());
		assertFalse(restaurant1.getName().equals(restaurantGet.getName()));
		restaurantService.deleteRestaurant(restaurantGet.getId());
	}*/
	
	//TODO handle delete request
	/*@Test
	public void testDeleterestaurant() throws Exception {
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setName("South Campus Cafe");
		restaurant1.setAddress("XYZ Street,Buffalo");
		RestaurantOwner owner1 = new RestaurantOwner();
		owner1.setName("ABCD");
		owner1.setPassword("ABCD");
		owner1.setUsername("ABCD");
		restaurant1.setOwner(owner1);
		restaurant1.setOwner(owner1);
		restaurant1.setOwner(ownerService.addRestaurantOwner(restaurant1.getOwner()));
		restaurant1 = restaurantService.addRestaurant(restaurant1);
		String content = "";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(RESTAURANT).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		restaurantService.deleteRestaurant(restaurant1.getId());
	}*/
	
		
}
