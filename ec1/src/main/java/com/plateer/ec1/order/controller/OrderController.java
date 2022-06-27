package com.plateer.ec1.order.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.ec1.order.service.OrderService;
import com.plateer.ec1.order.vo.OrderRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/order")
	public void order(OrderRequest request) {
		
	}
}
