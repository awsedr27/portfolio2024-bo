package com.portfolioBo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolioBo.admin.dto.AdminDto;
import com.portfolioBo.admin.dto.AdminRequest.AdminLoginRequest;
import com.portfolioBo.admin.dto.AdminServiceDto.AdminLoginServiceDto;
import com.portfolioBo.admin.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class AdminController {
	
	@Autowired
	AdminService adminService;

    @GetMapping("/login")
    public String login() {
        return "/login"; 
    }
    @PostMapping("/login")
    public String loginAction(HttpServletRequest request,Model model,@Valid @ModelAttribute AdminLoginRequest adminLoginRequest) {
    	try {
    		AdminLoginServiceDto adminLoginServiceDto=new AdminLoginServiceDto(adminLoginRequest);
    		AdminDto result= adminService.login(adminLoginServiceDto);
    		if(result==null) {
        		model.addAttribute("errorMessage", "아이디와 비밀번호를 확인해주세요");
    	        return "/login";
    		}else {
    			HttpSession session = request.getSession();
                session.setAttribute("admin", result);
    			return "redirect:/product/list";
    		}
    	}catch(Exception e) {
    		log.error("로그인에 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "서버 에러입니다. 잠시 후 다시 시도해주세요");
    		return "/login";
    	}
    	
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }
}
