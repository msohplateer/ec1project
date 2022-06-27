package com.plateer.ec1.payment.vo;

import lombok.Data;

@Data
public class CancelRequestVo {
	private String paymentType;
	private OriginalOrderVo originalOrderVo;
}
