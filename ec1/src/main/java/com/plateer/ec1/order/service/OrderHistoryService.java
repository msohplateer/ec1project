package com.plateer.ec1.order.service;

import org.springframework.stereotype.Service;

import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.OrderRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderHistoryService {
	
	public Long insertOrderHistory(OrderRequest request) {
		return null;
	}
	
	public void updateOrderHistory(Long historyNo, OrderVo oDto) {
	}
}
