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

import edu.buffalo.cse.ood.restaurantOrdering.model.SideItem;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantOrderingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.test.properties")
public class SideItemControllerTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private static String SIDE_ITEM = "/sideItem/";

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testGetAllSideItems() throws Exception {
		SideItem sideItem1 = new SideItem();
		sideItem1.setName("Cheeseburger");
		sideItem1.setCalories(100L);
		sideItem1.setPrice(4.5);
		SideItem sideItem2 = new SideItem();
		sideItem2.setName("Hamburger");
		sideItem1.setCalories(80L);
		sideItem1.setPrice(3.5);
		SideItem sideItem3 = new SideItem();
		sideItem3.setName("Big Mac");
		sideItem1.setCalories(500L);
		sideItem1.setPrice(8.0);
		List<SideItem> sideItems = new ArrayList<>();
		sideItems.add(sideItem1);
		sideItems.add(sideItem2);
		sideItems.add(sideItem3);

		for (SideItem sideItem : sideItems) {
			HttpEntity<SideItem> entity = new HttpEntity<SideItem>(sideItem, headers);
			restTemplate.exchange(createURLWithPort(SIDE_ITEM), HttpMethod.POST, entity,
					String.class);
		}
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(SIDE_ITEM), HttpMethod.GET, entity,
				String.class);
		ObjectMapper obj = new ObjectMapper();
		List<SideItem> sideItemList = obj.readValue(response.getBody(),new TypeReference<List<SideItem>>(){});
		for(SideItem sideItem: sideItems) {
			assertTrue(response.getBody().contains(sideItem.getName()));
		}
		assertTrue(sideItems.size() == sideItemList.size());
		for(SideItem sideItem : sideItemList) {
			HttpEntity<String> entity1 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(SIDE_ITEM + sideItem.getId()), HttpMethod.DELETE, entity1,
				String.class);
		}
	}

	
	 @Test public void testGetSideItem() throws Exception {
		 SideItem sideItem1 = new SideItem();
			sideItem1.setName("Chicken Burger");
			sideItem1.setCalories(200L);
			sideItem1.setPrice(5.5);
	  
	  HttpEntity<SideItem> entity = new HttpEntity<SideItem>(sideItem1, headers);
	  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(SIDE_ITEM), HttpMethod.POST, entity,
				String.class);
	  
	  ObjectMapper obj = new ObjectMapper();
	  SideItem sideItemNew = obj.readValue(response1.getBody().toString(), SideItem.class);
	  
	  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
	  ResponseEntity<String> response2 = restTemplate.exchange(createURLWithPort(SIDE_ITEM + sideItemNew.getId()), HttpMethod.GET, entity2,
				String.class);
	  assertEquals(response2.getStatusCodeValue(),HttpServletResponse.SC_OK);
	  assertTrue(response2.getBody().contains(sideItem1.getName()));
	  
	  HttpEntity<String> entity3 = new HttpEntity<String>(null, headers);
	  restTemplate.exchange(createURLWithPort(SIDE_ITEM + sideItemNew.getId()), HttpMethod.DELETE, entity3,
				String.class);
	 }
	  
	  @Test public void testAddSideItem() throws Exception { 
		  SideItem sideItem1 = new SideItem();
			sideItem1.setName("Veggie Burger");
			sideItem1.setCalories(100L);
			sideItem1.setPrice(4.0);
			int size = 0;
			
			HttpEntity<String> entityx = new HttpEntity<String>(null, headers);
			ResponseEntity<String> responsex = restTemplate.exchange(createURLWithPort(SIDE_ITEM), HttpMethod.GET, entityx,
					String.class);
			ObjectMapper objx = new ObjectMapper();
			List<SideItem> sideItemList = objx.readValue(responsex.getBody(),new TypeReference<List<SideItem>>(){});
			size = sideItemList.size();
			
		  HttpEntity<SideItem> entity = new HttpEntity<SideItem>(sideItem1, headers);
		  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(SIDE_ITEM), HttpMethod.POST, entity,
				String.class);
		  assertTrue(response1.getBody().contains(sideItem1.getName()));
		  ObjectMapper obj = new ObjectMapper();
		  SideItem sideItemNew = obj.readValue(response1.getBody().toString(), SideItem.class);
		  

			HttpEntity<String> entityNew = new HttpEntity<String>(null, headers);
			ResponseEntity<String> responsey = restTemplate.exchange(createURLWithPort(SIDE_ITEM), HttpMethod.GET, entityNew,
					String.class);
			ObjectMapper objy = new ObjectMapper();
			List<SideItem> sideItems = objy.readValue(responsey.getBody(),new TypeReference<List<SideItem>>(){});
			assertEquals(size, sideItems.size()-1);
		 	  
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(SIDE_ITEM + sideItemNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }
}
