package net.darinlina.mvcproject01.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.darinline.mvcproject01backend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Product product = (Product) target;
		
		if(product.getFile() == null || product.getFile().getOriginalFilename().contentEquals("")) {
			errors.rejectValue("file", null, "Please select a file to upload");
			return;
		}
		if(!(product.getFile().getContentType().equals("image/jpeg")
				|| product.getFile().getContentType().equals("image/png")
				|| product.getFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("file", null, "Please select an image of (jpeg, png or gif) extension");
			return;
		}
	}

}
