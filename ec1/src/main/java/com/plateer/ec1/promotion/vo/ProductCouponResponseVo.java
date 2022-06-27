package com.plateer.ec1.promotion.vo;

import java.util.List;

import lombok.Data;

@Data
public class ProductCouponResponseVo extends BaseResponseVo{
	private String memberNo;
	private List<ProductCouponsVo> productCouponsList;
}
