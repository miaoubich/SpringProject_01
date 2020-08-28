package net.darinlina.mvcproject01.handler;

import org.springframework.stereotype.Component;

import net.darinlina.mvcproject01.model.RegisterModel;
import net.darinline.mvcproject01backend.dto.Address;
import net.darinline.mvcproject01backend.dto.User;

@Component
public class RegisterHandler {
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
}
