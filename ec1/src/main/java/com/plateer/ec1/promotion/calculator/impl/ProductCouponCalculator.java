package com.plateer.ec1.promotion.calculator.impl;

import com.plateer.ec1.promotion.calculator.Calculator;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.base.PromotionRequestVo;
import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import com.plateer.ec1.promotion.vo.coupon.Coupon;
import com.plateer.ec1.promotion.vo.coupon.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.coupon.ProductCouponsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ProductCouponCalculator implements Calculator{
	
	@Override
	public PromotionType getType() {
		return PromotionType.PRD_CUP;
	}
		
	private Coupon getAvailablePromotionData(PromotionRequestVo prVo) {
		log.info("적용 가능 상품 쿠폰 데이터 조회");
		

		return null;
	}

	private ProductCouponResponseVo calculateDcAmt(PromotionRequestVo prVo, Coupon cpn) {
		log.info("상품 쿠폰 할인 적용 금액 계산");
		ProductCouponsVo pcVo = new ProductCouponsVo();
		List promotionList = new ArrayList();
		
		promotionList.add(cpn);
		pcVo.setProduct(prVo.getProductList().get(0));
		pcVo.setPromotionList(promotionList);
		
		ProductCouponResponseVo pcrVo = new ProductCouponResponseVo();
		List productCouponsList = new ArrayList();
		
		productCouponsList.add(pcVo);
		
		pcrVo.setMemberNo(prVo.getMemberNo());
		pcrVo.setProductCouponsList(productCouponsList);
		
		return pcrVo;
	}

	private ProductCouponResponseVo calculateMaxBenefit(ProductCouponResponseVo vo) {
		log.info("상품 쿠폰 최대혜택 계산");
		return vo;
	}

	@Override
	public BaseResponseVo getCalculationData(PromotionRequestVo prVo) {
		log.info("PriceDiscountCalculation getCalculationData call");
		Coupon coupon = getAvailablePromotionData(prVo);
		ProductCouponResponseVo vo = calculateDcAmt(prVo, coupon);
		ProductCouponResponseVo resVo = calculateMaxBenefit(vo);
		return resVo;
	}

}
