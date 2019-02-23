package com.ibdata.mvc.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler
	public ModelAndView exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		
		log.debug("Exception ::: {}", exception);
		
		ModelAndView modelAndView = new ModelAndView();
		
		InternalResourceView view = new InternalResourceView("/doException");
		modelAndView.setView(view);
		
		
		
		return modelAndView; 
	}
	
}
