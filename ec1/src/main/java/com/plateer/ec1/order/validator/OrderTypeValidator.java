package com.plateer.ec1.order.validator;

import java.util.function.Predicate;

import com.plateer.ec1.order.vo.OrderValidationVo;

public class OrderTypeValidator {

	// 모바일 쿠폰 상품 할인
	public static Predicate<OrderValidationVo> isEcouponOrderAvailableProduct = (dto) -> {
		return true;
	};
	
	// 모바일 쿠폰 필수 데이터 확인
	public static Predicate<OrderValidationVo> ecouponDataValidation = (dto) -> {
		return true;
	};
	
	// 일반 주문 상품 확인
	public static Predicate<OrderValidationVo> isGeneralOrderAvailableProduct = (dto) -> {
		return true;
	};
	
	// 일반 주문 필수 데이터 확인
	public static Predicate<OrderValidationVo> generalDataValidation = (dto) -> {
		return true;
	};
}
