package com.plateer.ec1.payment.service;

import org.springframework.stereotype.Service;

import com.plateer.ec1.payment.factory.PaymentFactory;
import com.plateer.ec1.payment.vo.ApproveResponseVo;
import com.plateer.ec1.payment.vo.CancelRequestVo;
import com.plateer.ec1.payment.vo.NetCancelRequestVo;
import com.plateer.ec1.payment.vo.PaymentInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayService {

	private final PaymentFactory paymentFactory;
	
	public ApproveResponseVo approvePayment(PaymentInfo piVo) {
		log.info("PayService Service ApprovePayment call : {}", piVo);
		return (ApproveResponseVo) paymentFactory.getPaymentService(piVo.getPaymentType()).approvePayment(piVo);
	}
	
	public void cancelPayment(CancelRequestVo crVo, String paymentType) {
		log.info("PayService Service cancelPayment call : {}", crVo);
		paymentFactory.getPaymentService(paymentType).cancelPayment(crVo.getOriginalOrderVo());
	}
	
	public void netCancelPayment(NetCancelRequestVo ncrVo, String paymentType) {
		log.info("PayService Service netCancelPayment call : {}", ncrVo);
		paymentFactory.getPaymentService(paymentType).netCancelPayment(ncrVo);
	}
}
