package com.portfolioBo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.portfolioBo.common.Interceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	Interceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")  
                .excludePathPatterns(
                		"/user/login", 
                		"/css/**", 
                		"/js/**",
                		"/favicon.ico"
                		);  
    }

	
}
