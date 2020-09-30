package net.darinlina.mvcproject01.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.darinlina.mvcproject01.model.UserModel;
import net.darinlina.mvcproject01backend.dao.CartLineDAO;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.CartLine;
import net.darinline.mvcproject01backend.dto.Product;

@Service("cartServices")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	//return the logged in current user
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//return the entire cart Lines
	public List<CartLine> getCartLines(){
		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());
	}

	public String updateCartLine(int cartLineId, int count) {
			//fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}else {
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			
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

	public String deleteCartLine(int cartLineId) {
		//fetch the cartLine by its id
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null)
			return "result=error";
		else {
			//update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);
			
			//remove the specific cartLine
			cartLineDAO.delete(cartLine);
			
			return "result=deleted";	
		}
	}
}
