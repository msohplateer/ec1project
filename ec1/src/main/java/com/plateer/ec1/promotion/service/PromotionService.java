package com.plateer.ec1.promotion.service;

import com.plateer.ec1.promotion.vo.coupon.CartCouponResponseVo;
import com.plateer.ec1.promotion.vo.pricediscount.PriceDiscountResponseVo;
import com.plateer.ec1.promotion.vo.coupon.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.base.PromotionRequestVo;

public interface PromotionService {
	public PriceDiscountResponseVo getPriceDiscountApplyData(PromotionRequestVo vo);
	public ProductCouponResponseVo getProductCouponApplyData(PromotionRequestVo vo);
	public CartCouponResponseVo getCartCouponApplyData(PromotionRequestVo vo);
}
