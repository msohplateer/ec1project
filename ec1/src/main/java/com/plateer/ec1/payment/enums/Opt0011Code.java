package com.plateer.ec1.payment.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Opt0011Code {
    PAYMENT_REQUEST("10", "결제요청"),
    PAYMENT_COMPLETE("20", "결제완료"),
    REFUND_COMPLETE("30", "환불완료");

    private final String code;
    private final String codeNm;
}
