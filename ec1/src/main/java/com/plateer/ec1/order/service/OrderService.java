package com.plateer.ec1.order.service;

import org.springframework.stereotype.Service;

import com.plateer.ec1.order.repository.OrderRepository;
import com.plateer.ec1.order.strategy.after.AfterStrategy;
import com.plateer.ec1.order.strategy.data.DataCreateStrategy;
import com.plateer.ec1.order.vo.OrderRequest;
import com.plateer.ec1.payment.service.PayService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderHistoryService orderHistoryService;
	
	private final PayService payService;
	
	private final OrderRepository orderRepository;
	
	public void order(OrderRequest request) {
		
	}
	
	private DataCreateStrategy getDataStrategy(OrderRequest request) {
		return null;
	}
	
	private AfterStrategy getAfterStrategy(OrderRequest request) {
		return null;
	}
}
