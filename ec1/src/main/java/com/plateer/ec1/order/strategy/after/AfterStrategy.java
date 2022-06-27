package com.plateer.ec1.order.strategy.after;

import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.OrderRequest;

public interface AfterStrategy {
	public void call(OrderRequest request, OrderVo oDto);
}
