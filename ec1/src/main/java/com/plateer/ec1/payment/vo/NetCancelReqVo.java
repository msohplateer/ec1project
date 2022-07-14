package com.plateer.ec1.payment.vo;

import com.plateer.ec1.payment.enums.PaymentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NetCancelReqVo {
    PaymentType paymentType;
}
