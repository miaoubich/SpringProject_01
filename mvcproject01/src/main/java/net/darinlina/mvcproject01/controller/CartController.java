package net.darinlina.mvcproject01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.darinlina.mvcproject01.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/show")
	public ModelAndView shawCart(@RequestParam(name = "result", required=false)String result) {
	ModelAndView mv = new ModelAndView("page");
	
	if(result != null) {
		
		switch(result) {
		case "added":
			mv.addObject("message", "CartLine has been successfully added !");
			break;
		case "updated":
			mv.addObject("message", "Your CartLine has been successfully updated !");
			break;
		case "error":
			mv.addObject("message", "Sorry we can't update yur CartLine, something went wrong !");
			break;
		case "delete":
			mv.addObject("message", "Carte Line has been removed !");
		}
	}
	
	mv.addObject("title", "User Cart");
	mv.addObject("userClickShowCart", true);
	mv.addObject("cartLines", cartService.getCartLines());
	
	return mv;
	}
	
	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {
		String response = cartService.updateCartLine(cartLineId, count);
		return "redirect:/cart/show?" + response;
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId) {
		String response = cartService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?" + response;
	}
	
	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId) {
		String response = cartService.addCartLine(productId);
		return "redirect:/cart/show?" + response;
	}
	
}
