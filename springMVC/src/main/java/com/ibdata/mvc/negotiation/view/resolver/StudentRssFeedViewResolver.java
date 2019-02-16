package com.ibdata.mvc.negotiation.view.resolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.ibdata.mvc.negotiation.view.StudentRssFeedView;

public class StudentRssFeedViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		StudentRssFeedView view = new StudentRssFeedView();
		return view;
	}

}
