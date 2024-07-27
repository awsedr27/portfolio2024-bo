package com.portfolioBo.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolioBo.category.dto.CategoryDto.ActiveCategoryListResult;
import com.portfolioBo.common.Paging;
import com.portfolioBo.order.dto.OrderDto;
import com.portfolioBo.order.dto.OrderDto.OrderItem;
import com.portfolioBo.order.dto.OrderRequest.OrdersListRequest;
import com.portfolioBo.order.dto.OrderServiceDto;
import com.portfolioBo.order.dto.OrderServiceDto.OrdersListServiceDto;
import com.portfolioBo.order.service.OrderService;
import com.portfolioBo.product.controller.ProductController;
import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductRequest.ProductListRequest;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

	
    @Value("${order.paging.page.size}")
    private int pagingSize;
    
    @Value("${order.paging.pagelist.size}")
    private int pagingListSize;
    
    @Autowired
    OrderService orderService;
    
    @GetMapping("/list")
    public String ordersList(Model model,@Valid @ModelAttribute OrdersListRequest ordersListRequest) {
    	try {
    		OrdersListServiceDto ordersListServiceDto=new OrdersListServiceDto(ordersListRequest);
        	Paging Paging=new Paging(ordersListRequest.getPage(), pagingSize,pagingListSize);
        	ordersListServiceDto.setPaging(Paging);
        	List<OrderDto> result=orderService.getOrdersList(ordersListServiceDto);
        	model.addAttribute("order", result);
        	model.addAttribute("paging", Paging);
        	model.addAttribute("search", ordersListRequest);
            return "/orders/list"; 
    	}catch(Exception e) {
    		log.error("주문목록을 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "주문목록을 불러오는데 실패했습니다");
    		return "/error";
    	}

    }
    
    @GetMapping("/detail")
    public String ordersDetail(@RequestParam(value = "orderId", required = true) Integer orderId, Model model) {
    	try {
    		List<OrderItem> result=orderService.getOrdersDetail(orderId);
            model.addAttribute("orderItems", result);	

            return "/orders/detail";
    	}catch(Exception e) {
    		log.error("주문 상세 정보를 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "주문 상세 정보를 불러오는데 실패했습니다");
    		return "/error";
    	}
    }
}
