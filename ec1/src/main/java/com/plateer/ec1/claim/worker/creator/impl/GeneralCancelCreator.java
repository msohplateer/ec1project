package com.plateer.ec1.claim.worker.creator.impl;

import java.util.List;

import com.plateer.ec1.claim.enums.ClaimType;
import com.plateer.ec1.claim.model.OrderBenefit;
import com.plateer.ec1.claim.model.OrderBenefitRelation;
import com.plateer.ec1.claim.model.OrderClaim;
import com.plateer.ec1.claim.model.OrderCost;
import com.plateer.ec1.claim.vo.ClaimVo;
import com.plateer.ec1.claim.worker.creator.ClaimCreator;
import com.plateer.ec1.order.enums.OrderClaimType;

public class GeneralCancelCreator implements ClaimCreator{

	@Override
	public ClaimType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderClaimType> makeInsertOrderClaim(ClaimVo dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderCost> makeInsertCost(ClaimVo dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderBenefitRelation> makeInsertOrderBenefitRelation(ClaimVo dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderClaim> makeUpdateOrderClaim(ClaimVo dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderCost> makeUpdateOrderCost(ClaimVo dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderBenefit> makeUpdateOrderBenefit(ClaimVo dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
