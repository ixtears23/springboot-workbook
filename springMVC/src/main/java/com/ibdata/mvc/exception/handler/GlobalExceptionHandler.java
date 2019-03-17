package com.ibdata.mvc.exception.handler;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(FileNotFoundException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "이유는 FileNotFoundException")
	public ModelAndView fileExceptionHandler(HttpServletRequest request, IOException exception) throws Exception {
		
		log.debug("FileNotFoundException ::: {}", exception);
		
		ModelAndView modelAndView = new ModelAndView();
		
		InternalResourceView view = new InternalResourceView("/home.do");
		modelAndView.setView(view);
		
		
		
		return modelAndView; 
	}
	
	@ExceptionHandler({ ArithmeticException.class })
	public String arithmeticExceptionHandler(HttpServletRequest request, ArithmeticException exception) throws Exception {
		
		log.debug("NullPointerException ::: {}", exception);
		return "forward:/home.do"; 
	}
	@ExceptionHandler({ NullPointerException.class })
	@ResponseStatus(code = HttpStatus.OK, reason = "이유는 NullPointerException")
	public String nullExceptionHandler(HttpServletRequest request, NullPointerException exception) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		InternalResourceView view = new InternalResourceView("/home.do");
		modelAndView.setView(view);
		log.debug("NullPointerException ::: {}", exception);
		return "home"; 
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "이유는 IndexOutOfBoundsException")
	public ModelAndView indexExceptionHandler(HttpServletRequest request, IndexOutOfBoundsException exception) throws Exception {
		
		log.debug("IndexOutOfBoundsException ::: {}", exception);
		
		ModelAndView modelAndView = new ModelAndView();
		
		InternalResourceView view = new InternalResourceView("/home.do");
		modelAndView.setView(view);
		
		return modelAndView; 
	}
	
}
