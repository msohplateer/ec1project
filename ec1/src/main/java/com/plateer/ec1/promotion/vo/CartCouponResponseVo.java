package com.plateer.ec1.promotion.vo;

import java.util.List;

import lombok.Data;

@Data
public class CartCouponResponseVo extends BaseResponseVo{
	private String memberNo;
	private List<CouponProductsVo> couponProductsList;
}
