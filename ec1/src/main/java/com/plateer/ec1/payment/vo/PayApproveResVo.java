package com.plateer.ec1.payment.vo;

import com.plateer.ec1.payment.enums.PaymentType;
import lombok.Data;

@Data
public class PayApproveResVo {
	private PaymentType paymentType;
	private String ablePartialCancelYn;
}
