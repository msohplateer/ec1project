package com.plateer.ec1.payment.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderInfoVo {
	private String ordNo;
	private String goodName;
	private String buyerName;
	private String telNo;
	private String buyerEmail;
}
