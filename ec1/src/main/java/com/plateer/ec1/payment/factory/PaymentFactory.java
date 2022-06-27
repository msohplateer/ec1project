package com.plateer.ec1.payment.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.plateer.ec1.payment.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PaymentFactory {
	
	private Map<String, PaymentService> paymentServiceMap = new HashMap();
	private final List<PaymentService> payments;
	
	public PaymentFactory(List<PaymentService> payments) {
		this.payments = payments;
		payments.forEach(p -> paymentServiceMap.put(p.getType(), p));
	}
	
	public PaymentService getPaymentService(String type) {
		log.info("PaymentFactory getPaymentService call : {}", type);
		return paymentServiceMap.get(type);
	}

}
