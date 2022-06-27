package com.plateer.ec1.promotion.calculator.impl;

import org.springframework.stereotype.Component;

import com.plateer.ec1.promotion.calculator.Calculator;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.BaseResponseVo;
import com.plateer.ec1.promotion.vo.PriceDiscountResponseVo;
import com.plateer.ec1.promotion.vo.Promotion;
import com.plateer.ec1.promotion.vo.PromotionRequestVo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PriceDiscountCalculator implements Calculator{
	
	@Override
	public PromotionType getType() {
		return PromotionType.PRC_DC;
	}
	
	private Promotion getAvailablePromotionData(PromotionRequestVo reqVo) {
		log.info("적용 가능 가격 할인 금액 데이터 조회");
		return new Promotion();
	}

	private PriceDiscountResponseVo calculateDcAmt(PromotionRequestVo reqVo, Promotion prm) {
		log.info("가격 할인 적용 금액 계산");
		PriceDiscountResponseVo rpdVo = new PriceDiscountResponseVo();
		rpdVo.setMemberNo(reqVo.getMemberNo());
		rpdVo.setProductList(reqVo.getProductList());
		return rpdVo;
	}


	@Override
	public BaseResponseVo getCalculationData(PromotionRequestVo prVo) {
		log.info("ResponseBaseVo getCalculationData call");
		Promotion promotion = getAvailablePromotionData(prVo);
		PriceDiscountResponseVo resVo = calculateDcAmt(prVo, promotion);
		return resVo;
	}

	
}
