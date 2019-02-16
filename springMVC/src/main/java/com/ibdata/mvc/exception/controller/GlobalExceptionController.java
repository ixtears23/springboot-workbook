package com.ibdata.mvc.exception.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalExceptionController {
	
	@RequestMapping("/doException")
	public String doException() {
		
		
		return "Test";
	}
	
	@RequestMapping("/jsonException")
	public ResponseEntity<?> jsonException(ModelMap modelMap) {
		
		ModelMap mMap = modelMap;
		ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<Map<String, Object>>(mMap, HttpStatus.OK);
		
		return responseEntity;
	}

}
