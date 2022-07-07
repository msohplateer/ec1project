package com.plateer.ec1.promotion.apply.service;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.factory.CalculatorFactory;
import com.plateer.ec1.promotion.vo.apply.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.apply.PromotionApplyRequestVo;
import com.plateer.ec1.promotion.vo.apply.CartCouponResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PromotionApplyService {

	private final CalculatorFactory factory;

//	public PriceDiscountResponseVo getPriceDiscountApplyData(PromotionRequestVo prVo) {
//			return (PriceDiscountResponseVo) factory.getPromotionCalculationData(PromotionType.PRC_DC).getCalculationData(prVo);
//			}
//
	public ProductCouponResponseVo getProductCouponApplyData(PromotionApplyRequestVo reqVo) {
		return (ProductCouponResponseVo) factory.getPromotionCalculationData(PromotionType.PRD_CUP).getCalculationData(reqVo);
	}


	public CartCouponResponseVo getCartCouponApplyData(PromotionApplyRequestVo reqVo) {
		return (CartCouponResponseVo) factory.getPromotionCalculationData(PromotionType.CART_CUP).getCalculationData(reqVo);
	}
}
