package com.plateer.ec1.payment.enums;

public enum PaymentType {
	INICIS("INICIS"),
	POINT("POINT");
	
	String paymentType;
	
	PaymentType(String paymentType){
		this.paymentType = paymentType;
	}
}
