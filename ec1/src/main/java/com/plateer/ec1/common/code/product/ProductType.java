package com.plateer.ec1.common.code.product;

import java.util.Arrays;

import com.plateer.ec1.order.enums.OrderClaimType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductType {
	GP("GENERAL_PRODUCT", "일반상품", "10"),
	MC("MOBILE_COUPON", "모바일쿠폰", "20");
	
	private final String typeEngNm;
	private final String typeKorNm;
	private final String typeCd;
	
	public static ProductType getProductTypeByName(String typeName) {
		return Arrays.stream(ProductType.values())
				.filter(t -> t.name().equals(typeName))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(""));
	}
}
