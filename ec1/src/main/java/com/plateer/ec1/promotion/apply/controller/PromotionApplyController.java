package com.plateer.ec1.promotion.apply.controller;

import com.plateer.ec1.promotion.apply.service.PromotionApplyService;
import com.plateer.ec1.promotion.vo.apply.CartCouponResponseVo;
import com.plateer.ec1.promotion.vo.apply.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.apply.PromotionApplyRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/promotion/apply")
@RequiredArgsConstructor
public class PromotionApplyController {
	
	private final PromotionApplyService promotionApplyService;
	
//	@PostMapping("/getPriceDiscountApplyInfo")
//	public PriceDiscountResponseVo getPriceDiscountApplyData(@RequestBody ApplyRequestVo vo) {
//		log.info("getPriceDiscountApplyInfo controller call request data :" + rpVo);
//		PriceDiscountResponseVo rpdVo = promotionService.getPriceDiscountApplyData(rpVo);
//		return rpdVo;
//	}
	
	@PostMapping("/getProductCouponApplyInfo")
	public ProductCouponResponseVo getProductCouponApplyData(@RequestBody PromotionApplyRequestVo reqVo) {
		log.info("getProductCouponApplyInfo controller call request data :" + reqVo);
		ProductCouponResponseVo rpcVo = promotionApplyService.getProductCouponApplyData(reqVo);
		return rpcVo; 
	}
	
	@PostMapping("/getCartCouponApplyInfo")
	public CartCouponResponseVo getCartCouponApplyData(@RequestBody PromotionApplyRequestVo reqVo) {
		CartCouponResponseVo rccVo = promotionApplyService.getCartCouponApplyData(reqVo);
		return rccVo;
	}
}
