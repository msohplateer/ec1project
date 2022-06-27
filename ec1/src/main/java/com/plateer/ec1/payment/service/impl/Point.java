package com.plateer.ec1.payment.service.impl;

import org.springframework.stereotype.Component;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.ApproveResponseVo;
import com.plateer.ec1.payment.vo.NetCancelRequestVo;
import com.plateer.ec1.payment.vo.OriginalOrderVo;
import com.plateer.ec1.payment.vo.PaymentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Point implements PaymentService{

	@Override
	public String getType() {
		return PaymentType.POINT.name();
	}
	
	private void validateAuth(PaymentInfo piDto) {
		log.info("POINT validateAuth call : {}", piDto);
	}

	@Override
	public ApproveResponseVo approvePayment(PaymentInfo piDto) {
		log.info("POINT approvePayment call : {}", piDto);
		validateAuth(piDto);
		return null;
	}

	@Override
	public void cancelPayment(OriginalOrderVo ooDto) {
		log.info("POINT cancelPayment call : {}", ooDto);
	}

	@Override
	public void netCancelPayment(NetCancelRequestVo ncrDto) {
		log.info("POINT netCancelPayment call : {}", ncrDto);
	}

}
