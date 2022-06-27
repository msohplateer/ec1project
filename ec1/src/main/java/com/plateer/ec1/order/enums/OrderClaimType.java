package com.plateer.ec1.order.enums;

import java.util.Arrays;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderClaimType {
	O("주문"),
	C("취소"),
	R("반품"),
	RC("반품철회"),
	X("교환");
	
	private final String typeKorNm;
	
	public static OrderClaimType getOrderClaimTypeByName(String typeName) {
		return Arrays.stream(OrderClaimType.values())
				.filter(t -> t.name().equals(typeName))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(""));
	}
}
