package com.plateer.ec1.promotion.service;

import com.plateer.ec1.promotion.vo.CartCouponResponseVo;
import com.plateer.ec1.promotion.vo.PriceDiscountResponseVo;
import com.plateer.ec1.promotion.vo.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.PromotionRequestVo;

public interface PromotionService {
	public PriceDiscountResponseVo getPriceDiscountApplyData(PromotionRequestVo vo);
	public ProductCouponResponseVo getProductCouponApplyData(PromotionRequestVo vo);
	public CartCouponResponseVo getCartCouponApplyData(PromotionRequestVo vo);
}
