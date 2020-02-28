package net.darinlina.mvcproject01.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.darinlina.mvcproject01backend.dao.CategoryDAO;
import net.darinlina.mvcproject01backend.dao.ProductDAO;
import net.darinline.mvcproject01backend.dto.Category;
import net.darinline.mvcproject01backend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();

		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		if (operation != null && operation.equals("product")) {
			mv.addObject("message", "Product has been added successfully!");
		}

		return mv;
	}

	// Handling product submition
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product nProduct, BindingResult results,
			Model model) {

		// check if there any errors
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");

			return "page";
		}

		logger.info(nProduct.toString());

		// create a new product record
		productDAO.add(nProduct);

		return "redirect:/manage/products?operation=product";
	}

	// returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.List();
	}

}
