package edu.buffalo.cse.ood.restaurantOrdering;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;
import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
import edu.buffalo.cse.ood.restaurantOrdering.model.Order;
import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;
import edu.buffalo.cse.ood.restaurantOrdering.model.Restaurant;
import edu.buffalo.cse.ood.restaurantOrdering.model.RestaurantOwner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantOrderingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.test.properties")
public class OrderControllerTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private static String ORDER = "/order/";
	private static String CUSTOMER = "/customer/";
	private static String RECIPE_ITEM = "/recipeItem/";
	private static String RESTAURANT_OWNER = "/restaurantOwner/";
	private static String RESTAURANT = "/restaurant/";



	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	/*@Test
	public void testGetAllOrders() throws Exception {
		Order order1 = new Order();
		
		Customer customer1 = new Customer();
		customer1.setName("mkr");
		customer1.setPassword("mkr");
		customer1.setUsername("mkr");
		order1.setCustomer(customer1);
		HttpEntity<Customer> entity = new HttpEntity<Customer>(customer1, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(CUSTOMER), HttpMethod.POST, entity,
				String.class);
		ObjectMapper obj1 = new ObjectMapper();
		order1.setCustomer(obj1.readValue(response.getBody(), Customer.class));
		
		RecipeItem item = new RecipeItem();
		item.setName("Pizza");
		item.setPrice(10.0);
		HttpEntity<RecipeItem> entity2 = new HttpEntity<RecipeItem>(item, headers);
		ResponseEntity<String> response2 = restTemplate.exchange(createURLWithPort(RECIPE_ITEM), HttpMethod.POST, entity2,
				String.class);
		ObjectMapper obj2 = new ObjectMapper();
		item = obj2.readValue(response2.getBody(), RecipeItem.class);
		List<Item> items = new ArrayList<>();
		items.add(item);
		order1.setItems(items);
		
		Restaurant restaurant1 = new Restaurant();
		restaurant1.setName(" Campus Cafe");
		restaurant1.setAddress("GF Street,Buffalo");
		RestaurantOwner owner1 = new RestaurantOwner();
		owner1.setName("A");
		owner1.setPassword("A");
		owner1.setUsername("A");
		HttpEntity<RestaurantOwner> entity3 = new HttpEntity<RestaurantOwner>(owner1, headers);
		ResponseEntity<String> response3 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity3,
				String.class);
		ObjectMapper obj3 = new ObjectMapper();
		owner1 = obj3.readValue(response3.getBody(), RestaurantOwner.class);
		restaurant1.setOwner(owner1);

		HttpEntity<Restaurant> entity4 = new HttpEntity<Restaurant>(restaurant1, headers);
		ResponseEntity<String> response4 = restTemplate.exchange(createURLWithPort(RESTAURANT), HttpMethod.POST, entity4,
				String.class);
		ObjectMapper obj4 = new ObjectMapper();
		restaurant1 = obj4.readValue(response4.getBody(), Restaurant.class);
		order1.setRestaurant(restaurant1);

		HttpEntity<Order> entity5 = new HttpEntity<Order>(order1, headers);
		restTemplate.exchange(createURLWithPort(ORDER), HttpMethod.POST, entity5,
				String.class);
		
		HttpEntity<String> entity6 = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response6 = restTemplate.exchange(createURLWithPort(ORDER), HttpMethod.GET, entity6,
				String.class);
		assertTrue(
				response6.getBody().contains(order1.getRestaurant().getName()) && response6.getBody().contains(order1.getItems().get(0).getName())
						&& response6.getBody().contains(order1.getCustomer().getUsername()));
		ObjectMapper obj = new ObjectMapper();
		Order order = obj.readValue(response.getBody().toString(),Order.class);
		HttpEntity<String> entity7 = new HttpEntity<String>(null, headers);
		restTemplate.exchange(createURLWithPort(ORDER + order.getId()), HttpMethod.DELETE, entity7,
			String.class);
		HttpEntity<String> entity8 = new HttpEntity<String>(null, headers);
		restTemplate.exchange(createURLWithPort(RESTAURANT + restaurant1.getId()), HttpMethod.DELETE, entity8,
			String.class);
		HttpEntity<String> entity9 = new HttpEntity<String>(null, headers);
		restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER + owner1.getId()), HttpMethod.DELETE, entity9,
			String.class);
		HttpEntity<String> entity10 = new HttpEntity<String>(null, headers);
		restTemplate.exchange(createURLWithPort(RECIPE_ITEM + item.getId()), HttpMethod.DELETE, entity10,
			String.class);
		HttpEntity<String> entity11 = new HttpEntity<String>(null, headers);
		restTemplate.exchange(createURLWithPort(CUSTOMER + customer1.getId()), HttpMethod.DELETE, entity11,
			String.class);
	}*/

	
	/* @Test public void testGetOrder() throws Exception {
		 Order order1 = new Order();
			
			Customer customer1 = new Customer();
			customer1.setName("tfg");
			customer1.setPassword("tfg");
			customer1.setUsername("tfg");
			order1.setCustomer(customer1);
			HttpEntity<Customer> entity = new HttpEntity<Customer>(customer1, headers);
			ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(CUSTOMER), HttpMethod.POST, entity,
					String.class);
			ObjectMapper obj1 = new ObjectMapper();
			order1.setCustomer(obj1.readValue(response.getBody(), Customer.class));
			RecipeItem item = new RecipeItem();
			item.setName("Ham");
			item.setPrice(10.0);
			HttpEntity<RecipeItem> entity2 = new HttpEntity<RecipeItem>(item, headers);
			ResponseEntity<String> response2 = restTemplate.exchange(createURLWithPort(RECIPE_ITEM), HttpMethod.POST, entity2,
					String.class);
			ObjectMapper obj2 = new ObjectMapper();
			item = obj2.readValue(response2.getBody(), RecipeItem.class);
			List<Item> items = new ArrayList<>();
			items.add(item);
			order1.setItems(items);
			
			Restaurant restaurant1 = new Restaurant();
			restaurant1.setName("Souh Campus Cafe");
			restaurant1.setAddress("XY Street,Buffalo");
			RestaurantOwner owner1 = new RestaurantOwner();
			owner1.setName("ABD");
			owner1.setPassword("ABD");
			owner1.setUsername("ABD");
			HttpEntity<RestaurantOwner> entity3 = new HttpEntity<RestaurantOwner>(owner1, headers);
			ResponseEntity<String> response3 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity3,
					String.class);
			ObjectMapper obj3 = new ObjectMapper();
			owner1 = obj3.readValue(response3.getBody(), RestaurantOwner.class);
			restaurant1.setOwner(owner1);

			HttpEntity<Restaurant> entity4 = new HttpEntity<Restaurant>(restaurant1, headers);
			ResponseEntity<String> response4 = restTemplate.exchange(createURLWithPort(RESTAURANT), HttpMethod.POST, entity4,
					String.class);
			ObjectMapper obj4 = new ObjectMapper();
			restaurant1 = obj4.readValue(response4.getBody(), Restaurant.class);
			order1.setRestaurant(restaurant1);

			HttpEntity<Order> entity5 = new HttpEntity<Order>(order1, headers);
			ResponseEntity<String> response5 = restTemplate.exchange(createURLWithPort(ORDER), HttpMethod.POST, entity5,
					String.class);
			ObjectMapper objx = new ObjectMapper();
			Order orderNew = objx.readValue(response5.getBody(), Order.class);
			
			HttpEntity<String> entity6 = new HttpEntity<String>(null, headers);
			ResponseEntity<String> response6 = restTemplate.exchange(createURLWithPort(ORDER + orderNew.getId()), HttpMethod.GET, entity6,
					String.class);
			System.out.println(response6.getBody());
			assertTrue(
					response6.getBody().contains(order1.getRestaurant().getName()) && response6.getBody().contains(order1.getItems().get(0).getName())
							&& response6.getBody().contains(order1.getCustomer().getUsername()));
			ObjectMapper obj = new ObjectMapper();
			Order order = obj.readValue(response6.getBody().toString(),Order.class);
			
			HttpEntity<String> entity7 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(ORDER + order.getId()), HttpMethod.DELETE, entity7,
				String.class);
			HttpEntity<String> entity8 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(RESTAURANT + restaurant1.getId()), HttpMethod.DELETE, entity8,
				String.class);
			HttpEntity<String> entity9 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER + owner1.getId()), HttpMethod.DELETE, entity9,
				String.class);
			HttpEntity<String> entity10 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(RECIPE_ITEM + item.getId()), HttpMethod.DELETE, entity10,
				String.class);
			HttpEntity<String> entity11 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(CUSTOMER + customer1.getId()), HttpMethod.DELETE, entity11,
				String.class);
	 }*/
	  
	  
	  @Test public void testAddOrder() throws Exception { 
		  Order order1 = new Order();
			
			Customer customer1 = new Customer();
			customer1.setName("rcw");
			customer1.setPassword("rcw");
			customer1.setUsername("rcw");
			HttpEntity<Customer> entity = new HttpEntity<Customer>(customer1, headers);
			ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(CUSTOMER), HttpMethod.POST, entity,
					String.class);
			ObjectMapper obj1 = new ObjectMapper();
			order1.setCustomer(obj1.readValue(response.getBody(), Customer.class));
			
			/*RecipeItem item = new RecipeItem();
			item.setName("Cheeseburger");
			item.setPrice(10.0);
			HttpEntity<RecipeItem> entity2 = new HttpEntity<RecipeItem>(item, headers);
			ResponseEntity<String> response2 = restTemplate.exchange(createURLWithPort(ITEM), HttpMethod.POST, entity2,
					String.class);
			ObjectMapper obj2 = new ObjectMapper();
			item = obj2.readValue(response2.getBody(), RecipeItem.class);
			List<Item> items = new ArrayList<>();
			items.add(item);
			order1.setItems(items);*/
			
			Restaurant restaurant1 = new Restaurant();
			restaurant1.setName("Soh Campus Cafe");
			restaurant1.setAddress("YZ Street,Buffalo");
			RestaurantOwner owner1 = new RestaurantOwner();
			owner1.setName("ACD");
			owner1.setPassword("ACD");
			owner1.setUsername("ACD");
			HttpEntity<RestaurantOwner> entity3 = new HttpEntity<RestaurantOwner>(owner1, headers);
			ResponseEntity<String> response3 = restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER), HttpMethod.POST, entity3,
					String.class);
			ObjectMapper obj3 = new ObjectMapper();
			owner1 = obj3.readValue(response3.getBody(), RestaurantOwner.class);
			restaurant1.setOwner(owner1);

			HttpEntity<Restaurant> entity4 = new HttpEntity<Restaurant>(restaurant1, headers);
			ResponseEntity<String> response4 = restTemplate.exchange(createURLWithPort(RESTAURANT), HttpMethod.POST, entity4,
					String.class);
			ObjectMapper obj4 = new ObjectMapper();
			restaurant1 = obj4.readValue(response4.getBody(), Restaurant.class);
			order1.setRestaurant(restaurant1);

			HttpEntity<Order> entity5 = new HttpEntity<Order>(order1, headers);
			ResponseEntity<String> response5 = restTemplate.exchange(createURLWithPort(ORDER), HttpMethod.POST, entity5,
					String.class);
			ObjectMapper objx = new ObjectMapper();
			Order orderNew = objx.readValue(response5.getBody(), Order.class);
			assertTrue(
					response5.getBody().contains(order1.getRestaurant().getName()) //&& response5.getBody().contains(order1.getItems().get(0).getName())
							&& response5.getBody().contains(order1.getCustomer().getUsername()));
			
			HttpEntity<String> entity7 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(ORDER + orderNew.getId()), HttpMethod.DELETE, entity7,
				String.class);
			HttpEntity<String> entity8 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(RESTAURANT + restaurant1.getId()), HttpMethod.DELETE, entity8,
				String.class);
			HttpEntity<String> entity9 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(RESTAURANT_OWNER + owner1.getId()), HttpMethod.DELETE, entity9,
				String.class);
			/*HttpEntity<String> entity10 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(ITEM + item.getId()), HttpMethod.DELETE, entity10,
				String.class);*/
			HttpEntity<String> entity11 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(CUSTOMER + customer1.getId()), HttpMethod.DELETE, entity11,
				String.class);
	  }
}
