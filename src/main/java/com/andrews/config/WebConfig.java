package com.andrews.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.andrews.dao.UserDAO;
import com.andrews.dao.UserDAOImplementation;
import com.andrews.service.UserService;
import com.andrews.service.UserServiceImplementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.andrews.controller")
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public UserDAO getUserDAO() {
		return new UserDAOImplementation();
	}
	
	@Bean 
	public UserService getOneService() {
		return new UserServiceImplementation();
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
		dataSource.setUsername("seadoge");
		dataSource.setPassword("787878");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
    public ViewResolver getviewResolver() {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setOrder(1);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        return viewResolver;
    }
	
	@Bean
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPaths("/", "/WEB-INF");
		return freeMarkerConfigurer;
	}
}
