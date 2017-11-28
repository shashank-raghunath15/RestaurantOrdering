package edu.buffalo.cse.ood.restaurantOrdering;

import static org.junit.Assert.*;

import java.util.List;

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

import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantOrderingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.test.properties")
public class RestaurantControllerTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private static String RESTAURANT = "/restaurant/";
	private static String RESTAURANT_OWNER = "/restaurantOwner/";

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testGetAllRestaurants() throws Exception {
		
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setAddress("1, New Road, Buffalo, NY");
		restaurant1.setName("McD");
		RestaurantOwner owner1 = new RestaurantOwner();
		owner1.setName("asdf");
		owner1.setPassword("asdf");
		owner1.setUsername("asdf");
		restaurant1.setOwner(owner1);
		HttpEntity<RestaurantOwner> entity3 = new HttpEntity<RestaurantOwner>(owner1, headers);
		ResponseEntity<String> response3 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity3,
				String.class);
		ObjectMapper obj3 = new ObjectMapper();
		owner1 = obj3.readValue(response3.getBody(), RestaurantOwner.class);
		restaurant1.setOwner(owner1);
		HttpEntity<Restaurant> entity4 = new HttpEntity<Restaurant>(restaurant1, headers);
		ResponseEntity<String> response4 = restTemplate.exchange(createURLWithPort(RESTAURANT), HttpMethod.POST, entity4,
				String.class);
		
		Restaurant restaurant2 = new Restaurant();
		restaurant2.setAddress("2, New Road, Buffalo, NY");
		restaurant2.setName("Wendys");
		RestaurantOwner owner2 = new RestaurantOwner();
		owner2.setName("dfgh");
		owner2.setPassword("dfgh");
		owner2.setUsername("dfgh");
		restaurant2.setOwner(owner2);
		HttpEntity<RestaurantOwner> entity9 = new HttpEntity<RestaurantOwner>(owner2, headers);
		ResponseEntity<String> response9 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity9,
				String.class);
		ObjectMapper objx = new ObjectMapper();
		owner2 = objx.readValue(response9.getBody(), RestaurantOwner.class);
		restaurant2.setOwner(owner2);

		HttpEntity<Restaurant> entityx = new HttpEntity<Restaurant>(restaurant2, headers);
		ResponseEntity<String> responsex = restTemplate.exchange(createURLWithPort(RESTAURANT), HttpMethod.POST, entityx,
				String.class);
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(RESTAURANT), HttpMethod.GET, entity,
				String.class);
		assertTrue(response.getBody().contains(restaurant1.getName())
						&& response.getBody().contains(restaurant2.getName()));
		ObjectMapper obj = new ObjectMapper();
		List<Restaurant> restaurantList = obj.readValue(response.getBody().toString(), new TypeReference<List<Restaurant>>(){});
		for(Restaurant restaurant : restaurantList) {
			HttpEntity<String> entity1 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(RESTAURANT + restaurant.getId()), HttpMethod.DELETE, entity1,
				String.class);
		}
	}

	
	/*@Test public void testGetRestaurant() throws Exception {
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setAddress("1, New Road, Buffalo, NY");
		restaurant1.setName("McD");
		RestaurantOwner owner1 = new RestaurantOwner();
		owner1.setName("asdf");
		owner1.setPassword("asdf");
		owner1.setUsername("asdf");
		restaurant1.setOwner(owner1);
		HttpEntity<RestaurantOwner> entity3 = new HttpEntity<RestaurantOwner>(owner1, headers);
		ResponseEntity<String> response3 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity3,
				String.class);
		ObjectMapper obj3 = new ObjectMapper();
		owner1 = obj3.readValue(response3.getBody(), RestaurantOwner.class);
		restaurant1.setOwner(owner1);
		HttpEntity<Restaurant> entity4 = new HttpEntity<Restaurant>(restaurant1, headers);
		ResponseEntity<String> response4 = restTemplate.exchange(createURLWithPort(RESTAURANT), HttpMethod.POST, entity4,
				String.class);
		ObjectMapper objm = new ObjectMapper();
		restaurant1 = objm.readValue(response4.getBody(), Restaurant.class);
		restaurant1.setOwner(owner1);
		assertTrue(restaurant1.getId() > 0);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(RESTAURANT + restaurant1.getId()), HttpMethod.GET, entity,
				String.class);
		ObjectMapper obj = new ObjectMapper();
		Restaurant restaurantGet = obj.readValue(response.getBody(),Restaurant.class);	
		assertEquals(restaurant1.getId(),restaurantGet.getId());
		HttpEntity<String> entity1 = new HttpEntity<String>(null, headers);
		restTemplate.exchange(createURLWithPort(RESTAURANT + restaurant1.getId()), HttpMethod.DELETE, entity1,
			String.class);
	 }*/
	  
	  
	  /*@Test public void testAddRestaurant() throws Exception { 
		  Restaurant restaurant1 = new Restaurant();
			restaurant1.setAddress("1, New Road, Buffalo, NY");
			restaurant1.setName("McD");
			RestaurantOwner owner1 = new RestaurantOwner();
			owner1.setName("asdf");
			owner1.setPassword("asdf");
			owner1.setUsername("asdf");
			restaurant1.setOwner(owner1);
			HttpEntity<RestaurantOwner> entity3 = new HttpEntity<RestaurantOwner>(owner1, headers);
			ResponseEntity<String> response3 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity3,
					String.class);
			ObjectMapper obj3 = new ObjectMapper();
			owner1 = obj3.readValue(response3.getBody(), RestaurantOwner.class);
			restaurant1.setOwner(owner1);
			System.out.println("ID is " + restaurant1.getId());
			HttpEntity<Restaurant> entity4 = new HttpEntity<Restaurant>(restaurant1, headers);
			ResponseEntity<String> response4 = restTemplate.exchange(createURLWithPort(RESTAURANT), HttpMethod.POST, entity4,
					String.class);
		  assertTrue(response4.getBody().contains(restaurant1.getName()));
		  ObjectMapper obj = new ObjectMapper();
		  Restaurant restaurantNew = obj.readValue(response4.getBody(), Restaurant.class);
		  System.out.println("ID is " + restaurantNew.getId() + " Yo " + response4.getBody() );
		  assertTrue(restaurantNew.getId()>0);
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(RESTAURANT + restaurantNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }*/
}
