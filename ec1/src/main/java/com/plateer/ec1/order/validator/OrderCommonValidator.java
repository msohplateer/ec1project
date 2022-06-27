package com.plateer.ec1.order.validator;

import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.plateer.ec1.order.vo.OrderValidationVo;

@Component
public class OrderCommonValidator {

	public static Predicate<OrderValidationVo> commonValidator = (dto) -> {
		return true;
	};
	
}
