package net.darinlina.mvcproject01backend;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.darinlina.mvcproject01backend.dao.CartLineDAO;
import net.darinlina.mvcproject01backend.dao.ProductDAO;
import net.darinlina.mvcproject01backend.dao.UserDAO;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.CartLine;
import net.darinline.mvcproject01backend.dto.Product;
import net.darinline.mvcproject01backend.dto.User;

public class CartLineTest {

	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void initializeBeans() {
		context = new AnnotationConfigApplicationContext(); 
		context.scan("net.darinlina.mvcproject01backend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
	}
	
//	@Test
	public void addNewCartLineTest() {
		
		//get the user
		user = userDAO.getByEmail("lina@home.com");
		
		//fetch the user's cart
		cart = user.getCart();
		
		//fetch the product
		product = productDAO.get(3);
		
		//create new cartLine
		cartLine = new CartLine();
		cartLine.setProduct(product);
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		System.out.println("cart.getId(): " + cart.getId());
		cartLine.setCartId(cart.getId());
		
		assertTrue(cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertTrue(cartLineDAO.updateCart(cart));
	}
	
	@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("mustafa@home.com");		
		Cart cart = user.getCart();
				
		cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), 1);
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
				
		double oldTotal = cartLine.getTotal();
				
		cartLine.setTotal(cartLine.getProduct().getUnitPrice() * cartLine.getProductCount());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertTrue(cartLineDAO.update(cartLine));	
	}
}
