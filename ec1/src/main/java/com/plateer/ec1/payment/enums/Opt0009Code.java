package com.plateer.ec1.payment.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Opt0009Code {
    VR_ACCT("10", "가상계좌"),
    POINT("20", "포인트");

    private final String code;
    private final String codeNm;

}
