package net.darinlina.mvcproject01backend.dao;

import java.util.List;

import net.darinline.mvcproject01backend.dto.Address;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
;	
	boolean updateCart(Cart cart);
}
