package net.darinlina.mvcproject01.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.darinlina.mvcproject01.model.UserModel;
import net.darinlina.mvcproject01backend.dao.UserDAO;
import net.darinline.mvcproject01backend.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if(session.getAttribute("userModel") == null) {
			// Add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userDAO.getByEmail(authentication.getName());
			
			if(user != null) {
				//Create a new UserModel object then pass the user details in it
				userModel = new UserModel();
				
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
//				userModel.setFullname(user.getFirstName() + " " + user.getLastName());
				userModel.setFullname(user.getFirstName());
				
				if(userModel.getRole().equals("USER")) {
					//set the cart only for buyer
					userModel.setCart(user.getCart());
				}
				
				//set the userModel in the session
				session.setAttribute("userModel", userModel); // the first userModel is the same variable in @ModelAttribute
				
				return userModel;
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
	}
}
