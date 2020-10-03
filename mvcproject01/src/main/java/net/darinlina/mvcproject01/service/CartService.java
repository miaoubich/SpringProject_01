package net.darinlina.mvcproject01.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.darinlina.mvcproject01.model.UserModel;
import net.darinlina.mvcproject01backend.dao.CartLineDAO;
import net.darinlina.mvcproject01backend.dao.ProductDAO;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.CartLine;
import net.darinline.mvcproject01backend.dto.Product;

@Service("cartServices")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private HttpSession session;

	// return the logged in current user
	private Cart getCart() {
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	// return the entire cart Lines
	public List<CartLine> getCartLines() {
		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());
	}

	public String updateCartLine(int cartLineId, int count) {
		// fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);

		if (cartLine == null) {
			return "result=error";
		} else {
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();

			//if the product quantity is available
			if(product.getQuantity() < count)
				return "result=unavailable";
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			cartLineDAO.update(cartLine);

			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);

			return "result=updated";
		}
	}

	public String addCartLine(int productId) {

		String response = null;

		Cart cart = this.getCart();
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		// fetch the product
		Product product = productDAO.get(productId);
		if (cartLine == null) {
			// add a new cartLine
			cartLine = new CartLine();

			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);// since its the 1st product to add in a new cartLine
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);

			cartLineDAO.add(cartLine);
			
			//update the cart also
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			response = "result=added";
		}
		else {
			//check if the cartLine has reached the maximum count
			if(cartLine.getProductCount() < product.getQuantity()) {
				//update the productCount for the cartLine
				response = this.updateCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
			}
			else {
				response = "result=maximum";
			}
		}

		return response;
	}

	public String deleteCartLine(int cartLineId) {
		// fetch the cartLine by its id
		CartLine cartLine = cartLineDAO.get(cartLineId);

		if (cartLine == null)
			return "result=error";
		else {
			// update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);

			// remove the specific cartLine
			cartLineDAO.delete(cartLine);

			return "result=deleted";
		}
	}

}
