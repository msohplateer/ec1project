package com.plateer.ec1.claim.vo;

import java.util.List;

import lombok.Data;

@Data
public class ClaimVo {
	private String orderClaimType;
	private String productType;
	private String orderNo;
	private String claimNo;
	private List<ClaimItem> claimItemList;
	private String claimReasonCd;
}
