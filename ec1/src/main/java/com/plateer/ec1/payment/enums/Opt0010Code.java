package com.plateer.ec1.payment.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Opt0010Code {
    PAYMENT("10", "결제"),
    CANCEL("20", "취소");

    private final String code;
    private final String codeNm;
}
