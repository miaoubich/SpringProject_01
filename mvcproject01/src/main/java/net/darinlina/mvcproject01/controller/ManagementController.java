package net.darinlina.mvcproject01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.darinlina.mvcproject01.util.FileUploadUtility;
import net.darinlina.mvcproject01.validator.ProductValidator;
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

	// Handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product nProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		// To check the image error message
		new ProductValidator().validate(nProduct, results);

		// check if there any errors
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("errorMessage", "Failed to add a product!");

			return "page";
		}

		logger.info(nProduct.toString());

		// create a new product record
		productDAO.add(nProduct);

		if (!nProduct.getFile().getOriginalFilename().contentEquals("")) {
			FileUploadUtility.uploadFile(request, nProduct.getFile(), nProduct.getCode());// request is used to get the
																							// real path of the image
		}

		return "redirect:/manage/products?operation=product";
	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		// fetch the product based on its id
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		// Change the status of the product activate or deactivate
		product.setActive(!product.isActive());
		productDAO.update(product);

		return (isActive) ? "Product with id " + product.getId() + " was successfully de-activated"
				: "Product with id " + product.getId() + " was activated successfully";
	}

	// returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.List();
	}

}
