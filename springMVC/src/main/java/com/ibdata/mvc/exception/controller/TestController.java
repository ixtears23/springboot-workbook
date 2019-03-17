package com.ibdata.mvc.exception.controller;

import java.nio.file.FileSystemNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/nullExMapping")
	public void nullExMapping() throws Exception {
		boolean exception = true;
		
		if(exception) {
			throw new NullPointerException();
		}
	}
	
	@RequestMapping("/arithmeticExMapping")
	public void arithmeticExMapping() throws Exception {
		boolean exception = true;
		
		if(exception) {
			throw new ArithmeticException();
		}
	}
	
	@RequestMapping("/indexExMapping")
	public void indexExMapping() throws Exception {
		boolean exception = true;
		
		if(exception) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@RequestMapping("/fileExMapping")
	public void fileExMapping() throws Exception {
		
		boolean exception = true;
		
		if(exception) {
			throw new FileSystemNotFoundException();
		}
	}
	
}
