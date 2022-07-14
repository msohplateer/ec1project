package com.plateer.ec1.order.vo;

import com.plateer.ec1.payment.vo.PayInfoVo;

import lombok.Data;

@Data
public class OrderRequest {
	private String orderNo;
	private String systemType;
	private String orderType;
	private PayInfoVo payInfoVo;
}
