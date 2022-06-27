package com.plateer.ec1.claim.vo;

import lombok.Data;

@Data
public class ClaimItem {
	private Long orderSeq;
	private Long processSeq;
	private String productNo;
	private String itemNo;
}
