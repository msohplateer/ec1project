package com.plateer.ec1.order.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderProcessStateType {
	//주문진행상태유형
	OS("ORDER_STANDBY", "주문대기", "10"),
	OC("ORDER_COMPLETE", "주문완료", "20"),
	CR("CANCEL_REQUEST", "취소요청", "30"),
	CC("CANCEL_COMPLETE", "취소완료", "40"),
	DC("DELIVERY_COMPLETE", "배송완료", "50"),
	RA("RETURN_ACCEPT", "반품접수", "60"),
	EA("EXCHANGE_ACCEPT", "교환접수", "70"),
	RWC("RETURN_WITHDRAWAL_COMPLETE", "반품철회완료", "80");
	
	private final String typeEngNm;
	private final String typeKorNm;
	private final String typeCd;
}
