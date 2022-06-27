package com.plateer.ec1.order.strategy.data;

import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.OrderRequest;

public interface DataCreateStrategy {
	public OrderVo create(OrderRequest request, OrderProductView opv);
}
