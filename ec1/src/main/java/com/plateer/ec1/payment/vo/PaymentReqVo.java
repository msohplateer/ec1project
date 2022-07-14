package com.plateer.ec1.payment.vo;

import lombok.Data;

import java.util.List;

@Data
public class PaymentReqVo {
	private OrderInfoVo orderInfoVo;
	private List<PayInfoVo> payInfoVoList;
}
