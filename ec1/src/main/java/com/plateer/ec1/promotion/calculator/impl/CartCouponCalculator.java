package com.plateer.ec1.promotion.calculator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.plateer.ec1.promotion.calculator.Calculator;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.BaseResponseVo;
import com.plateer.ec1.promotion.vo.CartCouponResponseVo;
import com.plateer.ec1.promotion.vo.CouponProductsVo;
import com.plateer.ec1.promotion.vo.Promotion;
import com.plateer.ec1.promotion.vo.PromotionRequestVo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CartCouponCalculator implements Calculator{
	
	@Override
	public PromotionType getType() {
		return PromotionType.CART_CUP;
	}

	private Promotion getAvailablePromotionData(PromotionRequestVo prVo) {
		log.info("적용 가능 장바구니 쿠폰 데이터 조회");
		
		Promotion promotion = new Promotion();
		
		promotion.setCouponIssueNo(100L);
		promotion.setDcAmt(1000L);
		promotion.setPromotionNo(1L);
		
		return new Promotion();
	}

	private CartCouponResponseVo calculateDcAmt(PromotionRequestVo prVo, Promotion prm) {
		log.info("장바구니 쿠폰 할인 적용 금액 계산");
		CouponProductsVo cpVo = new CouponProductsVo();
		List couponList = new ArrayList();
		
		cpVo.setProductList(prVo.getProductList());
		cpVo.setPromotion(prm);
		
		CartCouponResponseVo ccrVo = new CartCouponResponseVo();
		List couponProductsList = new ArrayList();
		
		couponProductsList.add(cpVo);
		
		ccrVo.setMemberNo(prVo.getMemberNo());
		ccrVo.setCouponProductsList(couponProductsList);
		
		return ccrVo;
	}

	private CartCouponResponseVo calculateMaxBenefit(CartCouponResponseVo vo) {
		log.info("장바구니 쿠폰 최대혜택 계산");
		return vo;
	}

	@Override
	public BaseResponseVo getCalculationData(PromotionRequestVo prVo) {
		log.info("CartCouponCalculation getCalculationData call");
		Promotion promotion = getAvailablePromotionData(prVo);
		CartCouponResponseVo vo = calculateDcAmt(prVo, promotion);
		CartCouponResponseVo resVo = calculateMaxBenefit(vo);
		return resVo;
	}

	

	
}
