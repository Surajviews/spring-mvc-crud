package com.srj.spring_mvc_crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc		
@ComponentScan(basePackages =  "com.srj.spring_mvc_crud.controller")
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean
	   public InternalResourceViewResolver resolver() {
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setViewClass(JstlView.class);
	      resolver.setPrefix("/WEB-INF/views/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   }
	
	
	 @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {

	      // Register resource handler for CSS and JS
	      registry.addResourceHandler("/assets/**").addResourceLocations("/WEB-INF/assets/");
	 }
	
}
