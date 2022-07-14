package com.plateer.ec1.payment.service;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.factory.PaymentFactory;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayApproveResVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayService {

	private final PaymentFactory paymentFactory;
	
	public PayApproveResVo approvePayment(PayInfoVo payInfoVo, OrderInfoVo orderInfoVo) throws Exception {
		return (PayApproveResVo) paymentFactory.getPaymentService(PaymentType.INICIS).approvePay(payInfoVo, orderInfoVo);
	}
	/*
	public void cancelPayment(CancelRequestVo crVo, String paymentType) {
		log.info("PayService Service cancelPayment call : {}", crVo);
		paymentFactory.getPaymentService(paymentType).cancelPayment(crVo.getOrderInfo());
	}
	
	public void netCancelPayment(NetCancelRequestVo ncrVo, String paymentType) {
		log.info("PayService Service netCancelPayment call : {}", ncrVo);
		paymentFactory.getPaymentService(paymentType).netCancelPayment(ncrVo);
	}
	 */
}
