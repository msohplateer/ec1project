package com.plateer.ec1.payment.service.impl;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PointPaymentServiceImpl implements PaymentService{

	@Override
	public PaymentType getType() {
		return PaymentType.POINT;
	}

	@Override
	public PayApproveResVo approvePay(PayInfoVo payInfoVo, OrderInfoVo orderInfoVo) throws Exception {
		return null;
	}

	@Override
	public void cancelPay(OriginalOrderVo originalOrderVo) {

	}

	@Override
	public void netCancel(NetCancelReqVo netCancelReqVo) {

	}
}
