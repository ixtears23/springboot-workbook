package com.ibdata.mvc.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
	@RequestMapping("/voidMapping")
	public void voidMapping() throws Exception {
		
		int x = 1;
		int y = 1; 
		
		if(x == y) {
			
			throw new Exception("Strubg");
		}
		
	}
	
}
