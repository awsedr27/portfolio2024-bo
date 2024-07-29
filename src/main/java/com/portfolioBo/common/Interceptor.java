package com.portfolioBo.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.portfolioBo.admin.dto.AdminDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class Interceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        String requestUrl = request.getRequestURL().toString();

        HttpSession session = request.getSession();
        AdminDto admin = (AdminDto) session.getAttribute("admin");
        if (admin == null) {
            response.sendRedirect("/user/login");
            return false;
        }
        return true;	
        }



}
