package com.plateer.ec1.order.validator;

import java.util.Arrays;
import java.util.function.Predicate;

import com.plateer.ec1.order.enums.OrderType;
import com.plateer.ec1.order.enums.SystemType;
import com.plateer.ec1.order.repository.OrderRepository;
import com.plateer.ec1.order.vo.OrderRequest;
import com.plateer.ec1.order.vo.OrderValidationVo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderValidator implements Predicate<OrderValidationVo>{
	FO_GENERAL(SystemType.FO, OrderType.GENERAL, OrderCommonValidator.commonValidator),
	BO_GENERAL(SystemType.BO, OrderType.GENERAL, OrderCommonValidator.commonValidator),
    FO_ECOUPON(SystemType.FO, OrderType.ECOUPON, OrderCommonValidator.commonValidator),
    BO_ECOUPON(SystemType.BO, OrderType.ECOUPON, OrderCommonValidator.commonValidator);
	
	private final SystemType systemType;
	
	private final OrderType orderType;
	
    private final Predicate<OrderValidationVo> validationDtoPredicate;

	@Override
	public boolean test(OrderValidationVo t) {
		return false;
	}
	
	public static OrderValidator get(OrderRequest orderRequest) {
		return Arrays.stream(values())
                .filter((t) -> t.systemType.equals(orderRequest.getSystemType()) && t.orderType.equals(orderRequest.getOrderType()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
	}
}
