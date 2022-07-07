package com.plateer.ec1.promotion.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Prm0001Code {
    PRICE_DISCOUNT("10"),
    COUPON("20");

    private final String value;
}
