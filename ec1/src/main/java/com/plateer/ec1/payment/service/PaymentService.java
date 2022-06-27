package com.plateer.ec1.payment.service;

import com.plateer.ec1.payment.vo.ApproveResponseVo;
import com.plateer.ec1.payment.vo.NetCancelRequestVo;
import com.plateer.ec1.payment.vo.OriginalOrderVo;
import com.plateer.ec1.payment.vo.PaymentInfo;

public interface PaymentService {
	String getType();
	ApproveResponseVo approvePayment(PaymentInfo piDto);
	void cancelPayment(OriginalOrderVo ooDto);
	void netCancelPayment(NetCancelRequestVo ncrDto);
}
