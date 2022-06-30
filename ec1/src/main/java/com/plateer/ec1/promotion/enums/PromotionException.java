package com.plateer.ec1.promotion.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PromotionException {

    CPN_CANCEL_PERIOD_EXCEPTION("쿠폰 복구 가능 기간이 아닙니다."),
    CPN_DWL_PERIOD_EXCEPTION("다운로드 가능 기간이 아닙니다."),
    CPN_DWL_COUNT_EXCEPTION("다운로드 가능 수량이 없습니다.");


    private final String MSG;
}
