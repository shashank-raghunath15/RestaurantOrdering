package edu.buffalo.cse.ood.restaurantOrdering;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.buffalo.cse.ood.restaurantOrdering.dto.Login;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantOrderingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.test.properties")
public class RestaurantOwnerControllerTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private static String RESTAURANT_OWNER = "/restaurantOwner/";
	private static String LOGIN = "/restaurantOwner/login/";

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testGetAllRestaurantOwners() throws Exception {
		RestaurantOwner restaurantOwner1 = new RestaurantOwner();
		restaurantOwner1.setAddress("1, New Road, Buffalo, NY");
		restaurantOwner1.setName("abc");
		restaurantOwner1.setPassword("abc");
		restaurantOwner1.setUsername("abc");
		RestaurantOwner restaurantOwner2 = new RestaurantOwner();
		restaurantOwner2.setAddress("55, Old Road, Syracuse, NY");
		restaurantOwner2.setName("def");
		restaurantOwner2.setPassword("def");
		restaurantOwner2.setUsername("def");
		RestaurantOwner restaurantOwner3 = new RestaurantOwner();
		restaurantOwner3.setAddress("25, New Street, Los Angeles, CA");
		restaurantOwner3.setName("xyz");
		restaurantOwner3.setPassword("xyz");
		restaurantOwner3.setUsername("xyz");
		List<RestaurantOwner> restaurantOwners = new ArrayList<>();
		restaurantOwners.add(restaurantOwner1);
		restaurantOwners.add(restaurantOwner2);
		restaurantOwners.add(restaurantOwner3);

		for (RestaurantOwner restaurantOwner : restaurantOwners) {
			HttpEntity<RestaurantOwner> entity = new HttpEntity<RestaurantOwner>(restaurantOwner, headers);
			restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity,
					String.class);
		}
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.GET, entity,
				String.class);
		assertTrue(
				response.getBody().contains(restaurantOwner1.getUsername()) && response.getBody().contains(restaurantOwner2.getUsername())
						&& response.getBody().contains(restaurantOwner2.getUsername()));
		ObjectMapper obj = new ObjectMapper();
		List<RestaurantOwner> restaurantOwnerList = obj.readValue(response.getBody().toString(), new TypeReference<List<RestaurantOwner>>(){});
		
		for(RestaurantOwner restaurantOwner : restaurantOwnerList) {
			HttpEntity<String> entity1 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER + restaurantOwner.getId()), HttpMethod.DELETE, entity1,
				String.class);
		}
	}

	
	 @Test public void testGetRestaurantOwner() throws Exception {
	  RestaurantOwner restaurantOwner1 = new RestaurantOwner(); 
	  restaurantOwner1.setAddress("2, New Road, Buffalo, NY");
	  restaurantOwner1.setName("tuv"); 
	  restaurantOwner1.setPassword("tuv"); 
	  restaurantOwner1.setUsername("tuv");
	  
	  HttpEntity<RestaurantOwner> entity = new HttpEntity<RestaurantOwner>(restaurantOwner1, headers);
	  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity,
				String.class);
	  ObjectMapper obj = new ObjectMapper();
	  RestaurantOwner restaurantOwnerNew = obj.readValue(response1.getBody().toString(), RestaurantOwner.class);
	  
	  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
	  ResponseEntity<String> response2 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER + restaurantOwnerNew.getId()), HttpMethod.GET, entity2,
				String.class);
	  assertEquals(response2.getStatusCodeValue(),HttpServletResponse.SC_OK);
	  assertTrue(response2.getBody().contains(restaurantOwner1.getUsername()));
	  HttpEntity<String> entity3 = new HttpEntity<String>(null, headers);
	  restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER + restaurantOwnerNew.getId()), HttpMethod.DELETE, entity3,
				String.class);
	 }
	  
	  @Test public void testLogin() throws Exception { 
		 RestaurantOwner restaurantOwner1 = new RestaurantOwner();
		 restaurantOwner1.setAddress("8, New Road, Buffalo, NY"); 
		 restaurantOwner1.setName("rst");
		 restaurantOwner1.setPassword("rst"); 
		 restaurantOwner1.setUsername("rst"); 
		 Login login = new Login();
		 login.setUsername(restaurantOwner1.getUsername());
		 login.setPassword(restaurantOwner1.getPassword()); 

		  HttpEntity<RestaurantOwner> entity = new HttpEntity<RestaurantOwner>(restaurantOwner1, headers);
		  ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity,
					String.class);
		  ObjectMapper obj = new ObjectMapper();
		  RestaurantOwner restaurantOwnerNew = obj.readValue(response.getBody().toString(), RestaurantOwner.class);
		  
		  HttpEntity<Login> entity1 = new HttpEntity<Login>(login, headers);
		  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(LOGIN), HttpMethod.POST, entity1,
					String.class);
		  assertFalse(response1.getBody().equals("-1"));
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER + restaurantOwnerNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }
	  
	  @Test public void testAddRestaurantOwner() throws Exception { 
		  RestaurantOwner restaurantOwner1 = new RestaurantOwner(); 
		  restaurantOwner1.setAddress("3, New Road, Buffalo, NY");
		  restaurantOwner1.setName("pqr"); 
		  restaurantOwner1.setPassword("pqr"); 
		  restaurantOwner1.setUsername("pqr");
		  HttpEntity<RestaurantOwner> entity = new HttpEntity<RestaurantOwner>(restaurantOwner1, headers);
		  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity,
				String.class);
		  assertTrue(response1.getBody().contains(restaurantOwner1.getUsername()));
		  ObjectMapper obj = new ObjectMapper();
		  RestaurantOwner restaurantOwnerNew = obj.readValue(response1.getBody().toString(), RestaurantOwner.class);
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER + restaurantOwnerNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }
}
