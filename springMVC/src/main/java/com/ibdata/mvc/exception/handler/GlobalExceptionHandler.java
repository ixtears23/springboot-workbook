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
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "진심 왜그러니")
	public ModelAndView fileExceptionHandler(HttpServletRequest request, IOException exception) throws Exception {
		
		log.debug("FileNotFoundException ::: {}", exception);
		
		ModelAndView modelAndView = new ModelAndView();
		
		InternalResourceView view = new InternalResourceView("/doException");
		modelAndView.setView(view);
		
		
		
		return modelAndView; 
	}
	
	@ExceptionHandler({ NullPointerException.class })
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "진심 왜그러니")
	public ModelAndView nullExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		
		log.debug("NullPointerException ::: {}", exception);
		
		ModelAndView modelAndView = new ModelAndView();
		
		InternalResourceView view = new InternalResourceView("/doException");
		modelAndView.setView(view);
		
		
		
		return modelAndView; 
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "진심 왜그러니")
	public ModelAndView indexExceptionHandler(HttpServletRequest request, IndexOutOfBoundsException exception) throws Exception {
		
		log.debug("IndexOutOfBoundsException ::: {}", exception);
		
		ModelAndView modelAndView = new ModelAndView();
		
		InternalResourceView view = new InternalResourceView("/doException");
		modelAndView.setView(view);
		
		
		
		return modelAndView; 
	}
	
}
