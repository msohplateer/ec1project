package com.plateer.ec1.claim.vo;

import java.util.List;

import com.plateer.ec1.claim.model.OrderBenefit;
import com.plateer.ec1.claim.model.OrderBenefitRelation;
import com.plateer.ec1.claim.model.OrderClaim;
import com.plateer.ec1.claim.model.OrderCost;

import lombok.Data;

@Data
public class ClaimPorcessVo {
	
	private String memberNo;
	private Long transactionNo;
	
	private List<OrderClaim> orderClaimList;
	private List<OrderCost> orderCostList;
	private List<OrderBenefitRelation> orderBenefitRelationList;
	private List<OrderBenefit> orderBenefitList;
}
