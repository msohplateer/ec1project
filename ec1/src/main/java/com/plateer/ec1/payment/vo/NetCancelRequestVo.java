package com.plateer.ec1.payment.vo;

import lombok.Data;

@Data
public class NetCancelRequestVo {
	private String paymentType;
	private String approveNo;
}
