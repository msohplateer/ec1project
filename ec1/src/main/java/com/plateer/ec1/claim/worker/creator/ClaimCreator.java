package com.plateer.ec1.claim.worker.creator;

import java.util.List;

import com.plateer.ec1.claim.enums.ClaimType;
import com.plateer.ec1.claim.model.OrderBenefit;
import com.plateer.ec1.claim.model.OrderBenefitRelation;
import com.plateer.ec1.claim.model.OrderClaim;
import com.plateer.ec1.claim.model.OrderCost;
import com.plateer.ec1.claim.vo.ClaimVo;
import com.plateer.ec1.order.enums.OrderClaimType;

public interface ClaimCreator {
	
	public ClaimType getType();
	public List<OrderClaimType> makeInsertOrderClaim(ClaimVo dto);
	public List<OrderCost> makeInsertCost(ClaimVo dto);
	public List<OrderBenefitRelation> makeInsertOrderBenefitRelation(ClaimVo dto);
	public List<OrderClaim> makeUpdateOrderClaim(ClaimVo dto);
	public List<OrderCost> makeUpdateOrderCost(ClaimVo dto);
	public List<OrderBenefit> makeUpdateOrderBenefit(ClaimVo dto);
	
}
