package com.plateer.ec1.payment.service;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.vo.*;

public interface PaymentService {
	PaymentType getType();
	PayApproveResVo approvePay(PayInfoVo payInfoVo, OrderInfoVo orderInfoVo) throws Exception;
	void cancelPay(OriginalOrderVo originalOrderVo);
	void netCancel(NetCancelReqVo netCancelReqVo);

}
