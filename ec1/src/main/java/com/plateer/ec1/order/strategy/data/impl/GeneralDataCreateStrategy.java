package com.plateer.ec1.order.strategy.data.impl;

import org.springframework.stereotype.Component;

import com.plateer.ec1.order.strategy.data.DataCreateStrategy;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.OrderRequest;

@Component
public class GeneralDataCreateStrategy implements DataCreateStrategy{

	@Override
	public OrderVo create(OrderRequest request, OrderProductView opv) {
		return null;
	}

}
