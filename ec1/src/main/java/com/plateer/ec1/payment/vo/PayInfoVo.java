package com.plateer.ec1.payment.vo;

import com.plateer.ec1.payment.enums.PaymentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayInfoVo {
	private Long paymentAmount;
	private String bankCode;
	private PaymentType paymentType;
	private String depositorName;

	public String getStringPaymentAmount(){
		return String.valueOf(this.paymentAmount);
	}

}
