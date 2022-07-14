package com.plateer.ec1.payment.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum InicisData {
    TYPE("Pay"),
    PAYMETHOD("Vacct"),
    URL("https://iniapi.inicis.com"),
    SUB_URL("https://iniweb.inicis.com/security/login.do"),
    MID("INIpayTest"),
    CURRENCY("WON"),
    API_KEY("ItEQKi3rY7uvDS8l"),
    GET_NO_PATH("/api/v1/formpay");

    private final String code;

}
