package com.plateer.ec1.promotion.calculator.impl;

import com.plateer.ec1.promotion.calculator.Calculator;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.base.PromotionRequestVo;
import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import com.plateer.ec1.promotion.vo.coupon.Coupon;
import com.plateer.ec1.promotion.vo.pricediscount.PriceDiscountResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PriceDiscountCalculator implements Calculator{
	
	@Override
	public PromotionType getType() {
		return PromotionType.PRC_DC;
	}
	
	private Coupon getAvailablePromotionData(PromotionRequestVo reqVo) {
		log.info("적용 가능 가격 할인 금액 데이터 조회");
		return new Coupon();
	}

	private PriceDiscountResponseVo calculateDcAmt(PromotionRequestVo reqVo, Coupon cpn) {
		log.info("가격 할인 적용 금액 계산");
		PriceDiscountResponseVo rpdVo = new PriceDiscountResponseVo();
		rpdVo.setMemberNo(reqVo.getMemberNo());
		rpdVo.setProductList(reqVo.getProductList());
		return rpdVo;
	}


	@Override
	public BaseResponseVo getCalculationData(PromotionRequestVo prVo) {
		log.info("ResponseBaseVo getCalculationData call");
		Coupon coupon = getAvailablePromotionData(prVo);
		PriceDiscountResponseVo resVo = calculateDcAmt(prVo, coupon);
		return resVo;
	}

	
}
