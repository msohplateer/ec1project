package com.plateer.ec1.payment.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.ec1.payment.service.PayService;
import com.plateer.ec1.payment.vo.ApproveResponseVo;
import com.plateer.ec1.payment.vo.CancelRequestVo;
import com.plateer.ec1.payment.vo.NetCancelRequestVo;
import com.plateer.ec1.payment.vo.PaymentInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {
	
	private final PayService payService;
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/approve")
	public ApproveResponseVo approvePayment(@RequestBody PaymentInfo piVo) {
		log.info("Payment Controller ApprovePayment call : {}", piVo);
		return payService.approvePayment(piVo);
	}
	
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
}
