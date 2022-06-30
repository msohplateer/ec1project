package com.plateer.ec1.promotion.controller;

import com.plateer.ec1.promotion.vo.base.PromotionRequestVo;
import com.plateer.ec1.promotion.vo.coupon.CartCouponResponseVo;
import com.plateer.ec1.promotion.vo.coupon.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.pricediscount.PriceDiscountResponseVo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.ec1.promotion.service.PromotionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/promotion")
@RequiredArgsConstructor
public class PromotionController {
	
	private final PromotionService promotionService;
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/getPriceDiscountApplyInfo")
	public PriceDiscountResponseVo getPriceDiscountApplyData(@RequestBody PromotionRequestVo rpVo) {
		log.info("getPriceDiscountApplyInfo controller call request data :" + rpVo);
		PriceDiscountResponseVo rpdVo = promotionService.getPriceDiscountApplyData(rpVo);
		return rpdVo; 
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/getProductCouponApplyInfo")
	public ProductCouponResponseVo getProductCouponApplyData(@RequestBody PromotionRequestVo rpVo) {
		log.info("getProductCouponApplyInfo controller call request data :" + rpVo);
		ProductCouponResponseVo rpcVo = promotionService.getProductCouponApplyData(rpVo);
		return rpcVo; 
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/getCartCouponApplyInfo")
	public CartCouponResponseVo getCartCouponApplyData(@RequestBody PromotionRequestVo rpVo) {
		CartCouponResponseVo rccVo = promotionService.getCartCouponApplyData(rpVo);
		return rccVo; 
	}
}
