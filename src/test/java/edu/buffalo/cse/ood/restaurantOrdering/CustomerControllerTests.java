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
import edu.buffalo.cse.ood.restaurantOrdering.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantOrderingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.test.properties")
public class CustomerControllerTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private static String CUSTOMER = "/customer/";
	private static String LOGIN = "/customer/login/";

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testGetAllCustomers() throws Exception {
		Customer customer1 = new Customer();
		customer1.setAddress("1, New Road, Buffalo, NY");
		customer1.setName("abc");
		customer1.setPassword("abc");
		customer1.setUsername("abc");
		Customer customer2 = new Customer();
		customer2.setAddress("55, Old Road, Syracuse, NY");
		customer2.setName("def");
		customer2.setPassword("def");
		customer2.setUsername("def");
		Customer customer3 = new Customer();
		customer3.setAddress("25, New Street, Los Angeles, CA");
		customer3.setName("xyz");
		customer3.setPassword("xyz");
		customer3.setUsername("xyz");
		List<Customer> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);

		for (Customer customer : customers) {
			HttpEntity<Customer> entity = new HttpEntity<Customer>(customer, headers);
			restTemplate.exchange(createURLWithPort(CUSTOMER), HttpMethod.POST, entity,
					String.class);
		}
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(CUSTOMER), HttpMethod.GET, entity,
				String.class);
		assertTrue(
				response.getBody().contains(customer1.getUsername()) && response.getBody().contains(customer2.getUsername())
						&& response.getBody().contains(customer2.getUsername()));
		ObjectMapper obj = new ObjectMapper();
		List<Customer> customerList = obj.readValue(response.getBody().toString(), new TypeReference<List<Customer>>(){});
		
		for(Customer customer : customerList) {
			HttpEntity<String> entity1 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(CUSTOMER + customer.getId()), HttpMethod.DELETE, entity1,
				String.class);
		}
	}

	
	 @Test public void testGetCustomer() throws Exception {
	  Customer customer1 = new Customer(); 
	  customer1.setAddress("1, New Road, Buffalo, NY");
	  customer1.setName("tuv"); 
	  customer1.setPassword("tuv"); 
	  customer1.setUsername("tuv");
	  
	  HttpEntity<Customer> entity = new HttpEntity<Customer>(customer1, headers);
	  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(CUSTOMER), HttpMethod.POST, entity,
				String.class);
	  ObjectMapper obj = new ObjectMapper();
	  Customer customerNew = obj.readValue(response1.getBody().toString(), Customer.class);
	  
	  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
	  ResponseEntity<String> response2 = restTemplate.exchange(createURLWithPort(CUSTOMER + customerNew.getId()), HttpMethod.GET, entity2,
				String.class);
	  assertEquals(response2.getStatusCodeValue(),HttpServletResponse.SC_OK);
	  assertTrue(response2.getBody().contains(customer1.getUsername()));
	  HttpEntity<String> entity3 = new HttpEntity<String>(null, headers);
	  restTemplate.exchange(createURLWithPort(CUSTOMER + customerNew.getId()), HttpMethod.DELETE, entity3,
				String.class);
	 }
	  
	  @Test public void testLogin() throws Exception { 
		 Customer customer1 = new Customer();
		 customer1.setAddress("1, New Road, Buffalo, NY"); 
		 customer1.setName("opq");
		 customer1.setPassword("opq"); 
		 customer1.setUsername("opq"); 
		 Login login = new Login();
		 login.setUsername(customer1.getUsername());
		 login.setPassword(customer1.getPassword()); 

		  HttpEntity<Customer> entity = new HttpEntity<Customer>(customer1, headers);
		  ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(CUSTOMER), HttpMethod.POST, entity,
					String.class);
		  ObjectMapper obj = new ObjectMapper();
		  Customer customerNew = obj.readValue(response.getBody().toString(), Customer.class);
		  
		  HttpEntity<Login> entity1 = new HttpEntity<Login>(login, headers);
		  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(LOGIN), HttpMethod.POST, entity1,
					String.class);
		  assertFalse(response1.getBody().equals("-1"));
		  
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(CUSTOMER + customerNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }
	  
	  @Test public void testAddCustomer() throws Exception { 
		  Customer customer1 = new Customer(); 
		  customer1.setAddress("1, New Road, Buffalo, NY");
		  customer1.setName("pqr"); 
		  customer1.setPassword("pqr"); 
		  customer1.setUsername("pqr");
		  HttpEntity<Customer> entity = new HttpEntity<Customer>(customer1, headers);
		  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(CUSTOMER), HttpMethod.POST, entity,
				String.class);
		  assertTrue(response1.getBody().contains(customer1.getUsername()));
		  ObjectMapper obj = new ObjectMapper();
		  Customer customerNew = obj.readValue(response1.getBody().toString(), Customer.class);
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(CUSTOMER + customerNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }
}
