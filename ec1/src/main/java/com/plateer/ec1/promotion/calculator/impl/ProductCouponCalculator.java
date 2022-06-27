package com.plateer.ec1.promotion.calculator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.plateer.ec1.promotion.calculator.Calculator;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.BaseResponseVo;
import com.plateer.ec1.promotion.vo.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.ProductCouponsVo;
import com.plateer.ec1.promotion.vo.Promotion;
import com.plateer.ec1.promotion.vo.PromotionRequestVo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductCouponCalculator implements Calculator{
	
	@Override
	public PromotionType getType() {
		return PromotionType.PRD_CUP;
	}
		
	private Promotion getAvailablePromotionData(PromotionRequestVo prVo) {
		log.info("적용 가능 상품 쿠폰 데이터 조회");
		
		Promotion promotion = new Promotion();
		
		promotion.setCouponIssueNo(100L);
		promotion.setDcAmt(1000L);
		promotion.setPromotionNo(1L);
		
		return promotion;
	}

	private ProductCouponResponseVo calculateDcAmt(PromotionRequestVo prVo, Promotion prm) {
		log.info("상품 쿠폰 할인 적용 금액 계산");
		ProductCouponsVo pcVo = new ProductCouponsVo();
		List promotionList = new ArrayList();
		
		promotionList.add(prm);
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
		Promotion promotion = getAvailablePromotionData(prVo);
		ProductCouponResponseVo vo = calculateDcAmt(prVo, promotion);
		ProductCouponResponseVo resVo = calculateMaxBenefit(vo);
		return resVo;
	}

}
