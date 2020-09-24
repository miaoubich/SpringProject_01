package net.darinlina.mvcproject01backend.dao;

import java.util.List;

import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.CartLine;

public interface CartLineDAO {

	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);

		//My business methods
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	//update the cart
	boolean updateCart(Cart cart);
}
