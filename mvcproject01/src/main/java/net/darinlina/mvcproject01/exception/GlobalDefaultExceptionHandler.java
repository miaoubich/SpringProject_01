package net.darinlina.mvcproject01.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "The page is not constructed!");
		mv.addObject("errorDescription", "The page you are looking for doesn't exist or is not available right now!");
		mv.addObject("title", "404 Error Page");

		return mv;

	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Product not available!");
		mv.addObject("errorDescription", "This product is out of stock right now, please check it out later!");
		mv.addObject("title", "Product unavailable");

		return mv;

	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Contact your administrator!");
		
		/*For debugging purpose we can print the whole stackTrace*/
//		StringWriter sw = new StringWriter();
//		PrintWriter pw = new PrintWriter(sw);
//		e.printStackTrace(pw);
//		mv.addObject("errorDescription", sw.toString());
		
		/*Otherwise we print a short error message*/
		mv.addObject("errorDescription", e.toString());
		mv.addObject("title", "Error");

		return mv;

	}
	
}
