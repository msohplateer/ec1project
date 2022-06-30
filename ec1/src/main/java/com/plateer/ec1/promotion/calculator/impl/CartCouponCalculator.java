package com.plateer.ec1.promotion.calculator.impl;

import com.plateer.ec1.promotion.calculator.Calculator;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.coupon.Coupon;
import com.plateer.ec1.promotion.vo.base.PromotionRequestVo;
import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import com.plateer.ec1.promotion.vo.coupon.CartCouponResponseVo;
import com.plateer.ec1.promotion.vo.coupon.CouponProductsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CartCouponCalculator implements Calculator{
	
	@Override
	public PromotionType getType() {
		return PromotionType.CART_CUP;
	}

	private Coupon getAvailablePromotionData(PromotionRequestVo prVo) {
		log.info("적용 가능 장바구니 쿠폰 데이터 조회");

		Coupon coupon = new Coupon();
		
		return new Coupon();
	}

	private CartCouponResponseVo calculateDcAmt(PromotionRequestVo prVo, Coupon cpn) {
		log.info("장바구니 쿠폰 할인 적용 금액 계산");
		CouponProductsVo cpVo = new CouponProductsVo();
		List couponList = new ArrayList();
		
		cpVo.setProductList(prVo.getProductList());
		cpVo.setCoupon(cpn);
		
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
		Coupon coupon = getAvailablePromotionData(prVo);
		CartCouponResponseVo vo = calculateDcAmt(prVo, coupon);
		CartCouponResponseVo resVo = calculateMaxBenefit(vo);
		return resVo;
	}

	

	
}
