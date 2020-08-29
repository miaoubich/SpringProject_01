package net.darinlina.mvcproject01.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.darinlina.mvcproject01.model.RegisterModel;
import net.darinlina.mvcproject01backend.dao.UserDAO;
import net.darinline.mvcproject01backend.dto.Address;
import net.darinline.mvcproject01backend.dto.Cart;
import net.darinline.mvcproject01backend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model) {
		
		String transitionValue = "success";
		
		//fetch the user
		User user = model.getUser();
		
		if(user.getRole().equalsIgnoreCase("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//save user
		userDAO.addUser(user);
		
		//getting the address
		Address billing = model.getBilling();
//		billing.setUserId(user.getId());
		billing.setUser(user);
		billing.setBilling(true);
		
		//save the Address
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
}
