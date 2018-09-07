package com.andrews.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInit implements WebApplicationInitializer {
	 public void onStartup(ServletContext ctx) throws ServletException {
	        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
	        webCtx.register(WebConfig.class);
	        webCtx.setServletContext(ctx);
	        ServletRegistration.Dynamic dispatcher = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	    }
}