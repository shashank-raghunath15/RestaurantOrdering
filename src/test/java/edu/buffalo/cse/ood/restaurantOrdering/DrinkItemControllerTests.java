package edu.buffalo.cse.ood.restaurantOrdering;

import static org.junit.Assert.assertEquals;
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

import edu.buffalo.cse.ood.restaurantOrdering.model.DrinkItem;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantOrderingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.test.properties")
public class DrinkItemControllerTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private static String DRINK_ITEM = "/drinkItem/";

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testGetAllDrinkItems() throws Exception {
		DrinkItem drinkItem1 = new DrinkItem();
		drinkItem1.setName("Cheeseburger");
		drinkItem1.setCalories(100L);
		drinkItem1.setPrice(4.5);
		DrinkItem drinkItem2 = new DrinkItem();
		drinkItem2.setName("Hamburger");
		drinkItem1.setCalories(80L);
		drinkItem1.setPrice(3.5);
		DrinkItem drinkItem3 = new DrinkItem();
		drinkItem3.setName("Big Mac");
		drinkItem1.setCalories(500L);
		drinkItem1.setPrice(8.0);
		List<DrinkItem> drinkItems = new ArrayList<>();
		drinkItems.add(drinkItem1);
		drinkItems.add(drinkItem2);
		drinkItems.add(drinkItem3);

		for (DrinkItem drinkItem : drinkItems) {
			HttpEntity<DrinkItem> entity = new HttpEntity<DrinkItem>(drinkItem, headers);
			restTemplate.exchange(createURLWithPort(DRINK_ITEM), HttpMethod.POST, entity,
					String.class);
		}
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(DRINK_ITEM), HttpMethod.GET, entity,
				String.class);
		ObjectMapper obj = new ObjectMapper();
		List<DrinkItem> drinkItemList = obj.readValue(response.getBody(),new TypeReference<List<DrinkItem>>(){});
		for(DrinkItem drinkItem: drinkItems) {
			assertTrue(response.getBody().contains(drinkItem.getName()));
		}
		assertTrue(drinkItems.size() == drinkItemList.size());
		for(DrinkItem drinkItem : drinkItemList) {
			HttpEntity<String> entity1 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(DRINK_ITEM + drinkItem.getId()), HttpMethod.DELETE, entity1,
				String.class);
		}
	}

	
	 @Test public void testGetDrinkItem() throws Exception {
		 DrinkItem drinkItem1 = new DrinkItem();
			drinkItem1.setName("Chicken Burger");
			drinkItem1.setCalories(200L);
			drinkItem1.setPrice(5.5);
	  
	  HttpEntity<DrinkItem> entity = new HttpEntity<DrinkItem>(drinkItem1, headers);
	  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(DRINK_ITEM), HttpMethod.POST, entity,
				String.class);
	  
	  ObjectMapper obj = new ObjectMapper();
	  DrinkItem drinkItemNew = obj.readValue(response1.getBody().toString(), DrinkItem.class);
	  
	  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
	  ResponseEntity<String> response2 = restTemplate.exchange(createURLWithPort(DRINK_ITEM + drinkItemNew.getId()), HttpMethod.GET, entity2,
				String.class);
	  assertEquals(response2.getStatusCodeValue(),HttpServletResponse.SC_OK);
	  assertTrue(response2.getBody().contains(drinkItem1.getName()));
	  
	  HttpEntity<String> entity3 = new HttpEntity<String>(null, headers);
	  restTemplate.exchange(createURLWithPort(DRINK_ITEM + drinkItemNew.getId()), HttpMethod.DELETE, entity3,
				String.class);
	 }
	  
	  @Test public void testAddDrinkItem() throws Exception { 
		  DrinkItem drinkItem1 = new DrinkItem();
			drinkItem1.setName("Veggie Burger");
			drinkItem1.setCalories(100L);
			drinkItem1.setPrice(4.0);
			int size = 0;
			
			HttpEntity<String> entityx = new HttpEntity<String>(null, headers);
			ResponseEntity<String> responsex = restTemplate.exchange(createURLWithPort(DRINK_ITEM), HttpMethod.GET, entityx,
					String.class);
			ObjectMapper objx = new ObjectMapper();
			List<DrinkItem> drinkItemList = objx.readValue(responsex.getBody(),new TypeReference<List<DrinkItem>>(){});
			size = drinkItemList.size();
			
		  HttpEntity<DrinkItem> entity = new HttpEntity<DrinkItem>(drinkItem1, headers);
		  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(DRINK_ITEM), HttpMethod.POST, entity,
				String.class);
		  assertTrue(response1.getBody().contains(drinkItem1.getName()));
		  ObjectMapper obj = new ObjectMapper();
		  DrinkItem drinkItemNew = obj.readValue(response1.getBody().toString(), DrinkItem.class);
		  

			HttpEntity<String> entityNew = new HttpEntity<String>(null, headers);
			ResponseEntity<String> responsey = restTemplate.exchange(createURLWithPort(DRINK_ITEM), HttpMethod.GET, entityNew,
					String.class);
			ObjectMapper objy = new ObjectMapper();
			List<DrinkItem> drinkItems = objy.readValue(responsey.getBody(),new TypeReference<List<DrinkItem>>(){});
			assertEquals(size, drinkItems.size()-1);
		 	  
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(DRINK_ITEM + drinkItemNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }
}
