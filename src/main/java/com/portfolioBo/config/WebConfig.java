package com.portfolioBo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.portfolioBo.common.Interceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	Interceptor interceptor;
	
	@Value("${img.upload.dir}")
    private String imageDir;

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
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String resourcePath = "file:" + imageDir + "/"; 
        registry.addResourceHandler("/images/**")
                .addResourceLocations(resourcePath);
    }
	
}
