package net.darinlina.mvcproject01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.darinlina.mvcproject01.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/show")
	public ModelAndView shawCart() {
	ModelAndView mv = new ModelAndView("page");
	
	mv.addObject("title", "User Cart");
	mv.addObject("userClickShowCart", true);
	mv.addObject("cartLines", cartService.getCartLines());
	
	return mv;
	}
	
}
