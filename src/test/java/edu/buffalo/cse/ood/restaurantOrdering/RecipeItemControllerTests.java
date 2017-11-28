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

import edu.buffalo.cse.ood.restaurantOrdering.model.RecipeItem;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantOrderingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.test.properties")
public class RecipeItemControllerTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private static String RECIPE_ITEM = "/recipeItem/";

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testGetAllRecipeItems() throws Exception {
		RecipeItem recipeItem1 = new RecipeItem();
		recipeItem1.setName("Cheeseburger");
		recipeItem1.setCalories(100L);
		recipeItem1.setPrice(4.5);
		RecipeItem recipeItem2 = new RecipeItem();
		recipeItem2.setName("Hamburger");
		recipeItem1.setCalories(80L);
		recipeItem1.setPrice(3.5);
		RecipeItem recipeItem3 = new RecipeItem();
		recipeItem3.setName("Big Mac");
		recipeItem1.setCalories(500L);
		recipeItem1.setPrice(8.0);
		List<RecipeItem> recipeItems = new ArrayList<>();
		recipeItems.add(recipeItem1);
		recipeItems.add(recipeItem2);
		recipeItems.add(recipeItem3);

		for (RecipeItem recipeItem : recipeItems) {
			HttpEntity<RecipeItem> entity = new HttpEntity<RecipeItem>(recipeItem, headers);
			restTemplate.exchange(createURLWithPort(RECIPE_ITEM), HttpMethod.POST, entity,
					String.class);
		}
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(RECIPE_ITEM), HttpMethod.GET, entity,
				String.class);
		ObjectMapper obj = new ObjectMapper();
		List<RecipeItem> recipeItemList = obj.readValue(response.getBody(),new TypeReference<List<RecipeItem>>(){});
		for(RecipeItem recipeItem: recipeItems) {
			assertTrue(response.getBody().contains(recipeItem.getName()));
		}
		assertTrue(recipeItems.size() == recipeItemList.size());
		for(RecipeItem recipeItem : recipeItemList) {
			HttpEntity<String> entity1 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(RECIPE_ITEM + recipeItem.getId()), HttpMethod.DELETE, entity1,
				String.class);
		}
	}

	
	 @Test public void testGetRecipeItem() throws Exception {
		 RecipeItem recipeItem1 = new RecipeItem();
			recipeItem1.setName("Chicken Burger");
			recipeItem1.setCalories(200L);
			recipeItem1.setPrice(5.5);
	  
	  HttpEntity<RecipeItem> entity = new HttpEntity<RecipeItem>(recipeItem1, headers);
	  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(RECIPE_ITEM), HttpMethod.POST, entity,
				String.class);
	  
	  ObjectMapper obj = new ObjectMapper();
	  RecipeItem recipeItemNew = obj.readValue(response1.getBody().toString(), RecipeItem.class);
	  
	  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
	  ResponseEntity<String> response2 = restTemplate.exchange(createURLWithPort(RECIPE_ITEM + recipeItemNew.getId()), HttpMethod.GET, entity2,
				String.class);
	  assertEquals(response2.getStatusCodeValue(),HttpServletResponse.SC_OK);
	  assertTrue(response2.getBody().contains(recipeItem1.getName()));
	  
	  HttpEntity<String> entity3 = new HttpEntity<String>(null, headers);
	  restTemplate.exchange(createURLWithPort(RECIPE_ITEM + recipeItemNew.getId()), HttpMethod.DELETE, entity3,
				String.class);
	 }
	  
	  @Test public void testAddRecipeItem() throws Exception { 
		  RecipeItem recipeItem1 = new RecipeItem();
			recipeItem1.setName("Veggie Burger");
			recipeItem1.setCalories(100L);
			recipeItem1.setPrice(4.0);
			int size = 0;
			
			HttpEntity<String> entityx = new HttpEntity<String>(null, headers);
			ResponseEntity<String> responsex = restTemplate.exchange(createURLWithPort(RECIPE_ITEM), HttpMethod.GET, entityx,
					String.class);
			ObjectMapper objx = new ObjectMapper();
			List<RecipeItem> recipeItemList = objx.readValue(responsex.getBody(),new TypeReference<List<RecipeItem>>(){});
			size = recipeItemList.size();
			
		  HttpEntity<RecipeItem> entity = new HttpEntity<RecipeItem>(recipeItem1, headers);
		  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(RECIPE_ITEM), HttpMethod.POST, entity,
				String.class);
		  assertTrue(response1.getBody().contains(recipeItem1.getName()));
		  ObjectMapper obj = new ObjectMapper();
		  RecipeItem recipeItemNew = obj.readValue(response1.getBody().toString(), RecipeItem.class);
		  

			HttpEntity<String> entityNew = new HttpEntity<String>(null, headers);
			ResponseEntity<String> responsey = restTemplate.exchange(createURLWithPort(RECIPE_ITEM), HttpMethod.GET, entityNew,
					String.class);
			ObjectMapper objy = new ObjectMapper();
			List<RecipeItem> recipeItems = objy.readValue(responsey.getBody(),new TypeReference<List<RecipeItem>>(){});
			assertEquals(size, recipeItems.size()-1);
		 	  
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(RECIPE_ITEM + recipeItemNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }
}
