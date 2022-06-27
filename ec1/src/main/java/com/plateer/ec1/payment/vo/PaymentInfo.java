package com.plateer.ec1.payment.vo;

import lombok.Data;

@Data
public class PaymentInfo {
	private String orderNo;
	private Long paymentAmount;
	private String paymentType;
}
