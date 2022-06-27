package com.plateer.ec1.order.vo;

import java.util.List;

public class OrderValidationVo {
	private OrderRequest request;
	private List<OrderProductView> product;
	
	public OrderValidationVo(OrderRequest request, List<OrderProductView> product) {
		this.request = request;
		this.product = product;
	}
}
