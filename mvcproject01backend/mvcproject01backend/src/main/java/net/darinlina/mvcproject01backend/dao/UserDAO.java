package net.darinlina.mvcproject01backend.dao;

import net.darinline.mvcproject01backend.dto.Address;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	
	boolean updateCart(Cart cart);
}
