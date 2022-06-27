package com.plateer.ec1.claim.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ValidatorType {
	CNL("CANCEL", "취소"),
	RTX("RETURN_EXCHANGE", "반품교환"),
	WDW("WITHDRAWAL", "철회");
	
	private final String typeEngNm;
	private final String typeKorNm;
}
