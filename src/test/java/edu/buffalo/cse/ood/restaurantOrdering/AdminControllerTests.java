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
import edu.buffalo.cse.ood.restaurantOrdering.model.Admin;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantOrderingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.test.properties")
public class AdminControllerTests {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private static String ADMIN = "/admin/";
	private static String LOGIN = "/admin/login/";

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testGetAllAdmins() throws Exception {
		Admin admin1 = new Admin();
		admin1.setAddress("1, New Road, Buffalo, NY");
		admin1.setName("abc");
		admin1.setPassword("abc");
		admin1.setUsername("abc");
		Admin admin2 = new Admin();
		admin2.setAddress("55, Old Road, Syracuse, NY");
		admin2.setName("def");
		admin2.setPassword("def");
		admin2.setUsername("def");
		Admin admin3 = new Admin();
		admin3.setAddress("25, New Street, Los Angeles, CA");
		admin3.setName("xyz");
		admin3.setPassword("xyz");
		admin3.setUsername("xyz");
		List<Admin> admins = new ArrayList<>();
		admins.add(admin1);
		admins.add(admin2);
		admins.add(admin3);

		for (Admin admin : admins) {
			HttpEntity<Admin> entity = new HttpEntity<Admin>(admin, headers);
			restTemplate.exchange(createURLWithPort(ADMIN), HttpMethod.POST, entity,
					String.class);
		}
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(ADMIN), HttpMethod.GET, entity,
				String.class);
		assertTrue(
				response.getBody().contains(admin1.getUsername()) && response.getBody().contains(admin2.getUsername())
						&& response.getBody().contains(admin3.getUsername()));
		ObjectMapper obj = new ObjectMapper();
		List<Admin> adminList = obj.readValue(response.getBody().toString(), new TypeReference<List<Admin>>(){});
		
		for(Admin admin : adminList) {
			HttpEntity<String> entity1 = new HttpEntity<String>(null, headers);
			restTemplate.exchange(createURLWithPort(ADMIN + admin.getId()), HttpMethod.DELETE, entity1,
				String.class);
		}
	}

	
	 @Test public void testGetAdmin() throws Exception {
	  Admin admin1 = new Admin(); 
	  admin1.setAddress("1, New Road, Buffalo, NY");
	  admin1.setName("tuv"); 
	  admin1.setPassword("tuv"); 
	  admin1.setUsername("tuv");
	  
	  HttpEntity<Admin> entity = new HttpEntity<Admin>(admin1, headers);
	  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(ADMIN), HttpMethod.POST, entity,
				String.class);
	  ObjectMapper obj = new ObjectMapper();
	  Admin adminNew = obj.readValue(response1.getBody().toString(), Admin.class);
	  
	  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
	  ResponseEntity<String> response2 = restTemplate.exchange(createURLWithPort(ADMIN + adminNew.getId()), HttpMethod.GET, entity2,
				String.class);
	  assertEquals(response2.getStatusCodeValue(),HttpServletResponse.SC_OK);
	  assertTrue(response2.getBody().contains(admin1.getUsername()));
	  HttpEntity<String> entity3 = new HttpEntity<String>(null, headers);
	  restTemplate.exchange(createURLWithPort(ADMIN + adminNew.getId()), HttpMethod.DELETE, entity3,
				String.class);
	 }
	  
	  @Test public void testLogin() throws Exception { 
		 Admin admin1 = new Admin();
		 admin1.setAddress("1, New Road, Buffalo, NY"); 
		 admin1.setName("opq");
		 admin1.setPassword("opq"); 
		 admin1.setUsername("opq"); 
		 Login login = new Login();
		 login.setUsername(admin1.getUsername());
		 login.setPassword(admin1.getPassword()); 

		  HttpEntity<Admin> entity = new HttpEntity<Admin>(admin1, headers);
		  ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(ADMIN), HttpMethod.POST, entity,
					String.class);
		  ObjectMapper obj = new ObjectMapper();
		  Admin adminNew = obj.readValue(response.getBody().toString(), Admin.class);
		  
		  HttpEntity<Login> entity1 = new HttpEntity<Login>(login, headers);
		  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(LOGIN), HttpMethod.POST, entity1,
					String.class);
		  assertFalse(response1.getBody().equals("-1"));
		  
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(ADMIN + adminNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }
	  
	  @Test 
	  public void testAddAdmin() throws Exception { 
		  Admin admin1 = new Admin(); 
		  admin1.setAddress("1, New Road, Buffalo, NY");
		  admin1.setName("pqr"); 
		  admin1.setPassword("pqr"); 
		  admin1.setUsername("pqr");
		  HttpEntity<Admin> entity = new HttpEntity<Admin>(admin1, headers);
		  ResponseEntity<String> response1 = restTemplate.exchange(createURLWithPort(ADMIN), HttpMethod.POST, entity,
				String.class);
		  assertTrue(response1.getBody().contains(admin1.getUsername()));
		  ObjectMapper obj = new ObjectMapper();
		  Admin adminNew = obj.readValue(response1.getBody().toString(), Admin.class);
		  HttpEntity<String> entity2 = new HttpEntity<String>(null, headers);
		  restTemplate.exchange(createURLWithPort(ADMIN + adminNew.getId()), HttpMethod.DELETE, entity2,
			String.class);
	  }
}
