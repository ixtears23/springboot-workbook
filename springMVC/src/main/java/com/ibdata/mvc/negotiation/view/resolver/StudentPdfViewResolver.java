package com.ibdata.mvc.negotiation.view.resolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.ibdata.mvc.negotiation.view.StudentPdfView;

public class StudentPdfViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		StudentPdfView pdfView = new StudentPdfView();
		return pdfView;
	}

}
