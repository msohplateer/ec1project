package com.plateer.ec1.order.strategy.after.impl;

import org.springframework.stereotype.Component;

import com.plateer.ec1.order.strategy.after.AfterStrategy;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.OrderRequest;

@Component
public class BoAfterStrategy implements AfterStrategy{

	@Override
	public void call(OrderRequest request, OrderVo oDto) {
		
	}
	
}
