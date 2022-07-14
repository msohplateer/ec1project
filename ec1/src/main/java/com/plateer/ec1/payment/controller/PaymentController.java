package com.plateer.ec1.payment.controller;

import com.plateer.ec1.payment.vo.OrderInfoVo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.ec1.payment.service.PayService;
import com.plateer.ec1.payment.vo.PayApproveResVo;
import com.plateer.ec1.payment.vo.PayInfoVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {
	
	private final PayService payService;
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/approve")
	public PayApproveResVo approvePayment(@RequestBody PayInfoVo piVo, OrderInfoVo oiVo) throws Exception {
		return payService.approvePayment(piVo, oiVo);
	}

	/*
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/cancel")
	public void cancelPayment(@RequestBody CancelRequestVo crVo) {
		log.info("Payment Controller cancelPayment call : {}", crVo);
		payService.cancelPayment(crVo, crVo.getPaymentType());
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/netCancel")
	public void netCancelPayment(@RequestBody NetCancelRequestVo ncrVo) {
		log.info("Payment Controller netCancelPayment call : {}", ncrVo);
		payService.netCancelPayment(ncrVo, ncrVo.getPaymentType());
	}
	 */
}
