package com.plateer.ec1.promotion.vo.coupon;

import java.util.List;

import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import lombok.Data;

@Data
public class CartCouponResponseVo extends BaseResponseVo {
	private String memberNo;
	private List<CouponProductsVo> couponProductsList;
}
