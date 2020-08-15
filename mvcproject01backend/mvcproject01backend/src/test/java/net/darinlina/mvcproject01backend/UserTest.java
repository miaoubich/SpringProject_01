package net.darinlina.mvcproject01backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.darinlina.mvcproject01backend.dao.UserDAO;
import net.darinline.mvcproject01backend.dto.Address;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.User;

public class UserTest {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;
	
	@BeforeClass
	public static void beforeClass() {
		context = new  AnnotationConfigApplicationContext();
		context.scan("net.darinlina.mvcproject01backend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Enrik");
		user.setLastName("Bouzar");
		user.setEmail("enrik.bouzar@gmail.com");
		user.setContactNumber("0998654495");
		user.setRole("USER");
		user.setPassword("8520");
		
		assertEquals("User has been added successfully", true, userDAO.addUser(user));
	
		address = new Address();
		address.setAddressLineOne("this is address one !");
		address.setAddressLineTwo("this is address line two !");
		address.setCity("Split");
		address.setState("Dalmacia");
		address.setCountry("Hrvatska");
		address.setPostalCode("21000");
		address.setBilling(true);
		
		//link the created user with its address using userId
		address.setUserId(user.getId());
		
		assertEquals("Address has been added successfully", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			//Create a cart for this user
			cart = new Cart();
			cart.setUserId(user.getId());
			
			assertEquals("Cart has been added successfully", true, userDAO.addCart(cart));
			
			//add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("this is shipping address one !");
			address.setAddressLineTwo("this is shipping address line two !");
			address.setCity("Korčula");
			address.setState("Dubravačka");
			address.setCountry("Hrvatska");
			address.setPostalCode("20260");
			//set shipping true
			address.setShipping(true);
			
			//link i tto this user
			address.setUserId(user.getId());
			
			assertEquals("Shipping address has been added successfully", true, userDAO.addAddress(address));
			
			
		}
	
	}
}
