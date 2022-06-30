package com.plateer.ec1.promotion.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PromotionType {
	PRC_DC("PA"),
	PRD_CUP("PC"),
	CART_CUP("CC");
	
	private final String prmType;
}
