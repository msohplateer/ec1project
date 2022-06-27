package com.plateer.ec1.promotion.enums;

public enum PromotionType {
	PRC_DC("PA"),
	PRD_CUP("PC"),
	CART_CUP("CC");
	
	String prmType;
	
	PromotionType(String prmType){
		this.prmType = prmType;
	}
}
