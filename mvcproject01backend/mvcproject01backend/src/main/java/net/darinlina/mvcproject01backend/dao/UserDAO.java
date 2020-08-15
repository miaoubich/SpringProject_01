package net.darinlina.mvcproject01backend.dao;

import net.darinline.mvcproject01backend.dto.Address;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart(Cart cart);
}
