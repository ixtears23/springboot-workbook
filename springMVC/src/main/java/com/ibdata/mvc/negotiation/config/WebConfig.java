package com.ibdata.mvc.negotiation.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ibdata.mvc.negotiation.view.resolver.StudentExcelViewResolver;
import com.ibdata.mvc.negotiation.view.resolver.StudentJsonViewResolver;
import com.ibdata.mvc.negotiation.view.resolver.StudentPdfViewResolver;
import com.ibdata.mvc.negotiation.view.resolver.StudentRssFeedViewResolver;
import com.ibdata.mvc.negotiation.view.resolver.StudentXmlViewResolver;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "com.boraji.tutorial.spring.controller" })
public class WebConfig 
//implements WebMvcConfigurer
{

   // Customize the content negotiation options
//   @Override
//   public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//      configurer.defaultContentType(MediaType.TEXT_HTML)
//      .favorPathExtension(true)
//      .favorParameter(false)
//      .ignoreAcceptHeader(true);
//   }
   
   // Setting different views using  the ContentNegotiatingViewResolver
   @Bean
   public ContentNegotiatingViewResolver viewResolver(ContentNegotiationManager cnManager) {

      ContentNegotiatingViewResolver cnResolver = new ContentNegotiatingViewResolver();
      cnResolver.setContentNegotiationManager(cnManager);

      // Excel View Resolver
      StudentExcelViewResolver excelResolver = new StudentExcelViewResolver();

      // PDF View Resolver
      StudentPdfViewResolver pdfResolver = new StudentPdfViewResolver();

      // XML View Resolver
      StudentXmlViewResolver xmlResolver = new StudentXmlViewResolver();

      // JSON View Resolver
      StudentJsonViewResolver jsonResolver = new StudentJsonViewResolver();

      // RSS FEED view resolver
      StudentRssFeedViewResolver feedResolver = new StudentRssFeedViewResolver();

      // JSP View Resolver
      InternalResourceViewResolver jspResolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");

      // Add views to list
      List<ViewResolver> resolvers = new ArrayList<>();
      resolvers.add(jspResolver);
      resolvers.add(excelResolver);
      resolvers.add(pdfResolver);
      resolvers.add(xmlResolver);
      resolvers.add(jsonResolver);
      resolvers.add(feedResolver);
      
      cnResolver.setViewResolvers(resolvers);
      return cnResolver;
   }
}
