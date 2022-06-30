package com.plateer.ec1.promotion.service.impl;

import org.springframework.stereotype.Service;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.factory.CalculatorFactory;
import com.plateer.ec1.promotion.service.PromotionService;
import com.plateer.ec1.promotion.vo.coupon.CartCouponResponseVo;
import com.plateer.ec1.promotion.vo.pricediscount.PriceDiscountResponseVo;
import com.plateer.ec1.promotion.vo.coupon.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.base.PromotionRequestVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService{
	
	private final CalculatorFactory factory;
	
	@Override
	public PriceDiscountResponseVo getPriceDiscountApplyData(PromotionRequestVo prVo) {
		return (PriceDiscountResponseVo) factory.getPromotionCalculationData(PromotionType.PRC_DC).getCalculationData(prVo);  
	}

	@Override
	public ProductCouponResponseVo getProductCouponApplyData(PromotionRequestVo prVo) {
		return (ProductCouponResponseVo) factory.getPromotionCalculationData(PromotionType.PRD_CUP).getCalculationData(prVo);  
	}

	@Override
	public CartCouponResponseVo getCartCouponApplyData(PromotionRequestVo prVo) {
		return (CartCouponResponseVo) factory.getPromotionCalculationData(PromotionType.CART_CUP).getCalculationData(prVo);  
	}

}
