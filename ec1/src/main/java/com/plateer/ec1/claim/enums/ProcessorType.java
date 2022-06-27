package com.plateer.ec1.claim.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProcessorType {
	ACW("ACCEPT_WITHDRAWAL"),
	CPT("COMPLETE");
	
	private final String typeEngNm;
}
