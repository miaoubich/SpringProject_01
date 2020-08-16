package net.darinlina.mvcproject01backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		context = new AnnotationConfigApplicationContext();
		context.scan("net.darinlina.mvcproject01backend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

//	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Enrik");
		user.setLastName("Bouzar");
		user.setEmail("enrik.bouzar@gmail.com");
		user.setContactNumber("0998654495");
		user.setRole("USER");
		user.setPassword("8520");

		if (user.getRole().equals("USER")) {
			// Create a cart for this user
			cart = new Cart();
			cart.setUser(user);

			// attach cart with the user
			user.setCart(cart);
		}
		//add the user
		assertEquals("Failed to add the user", true, userDAO.addUser(user));
		

	}
	
	@Test
	public void updateCartTest() {
		//get the user by its email
		user = userDAO.getByEmail("enrik.bouzar@gmail.com");
		//get the cart of this user
		cart = user.getCart();
		
		//update the cart
		cart.setCartLines(3);
		cart.setGrandTotal(2222);
		
		assertTrue(userDAO.updateCart(cart));
	}
}
