package com.plateer.ec1.order.validator;

import java.util.function.Predicate;

import com.plateer.ec1.order.vo.OrderValidationVo;

public class OrderProductValidator {
	public static Predicate<OrderValidationVo> isSellingProduct = (dto) -> {
		return true;
	};
}
