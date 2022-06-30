package com.plateer.ec1.promotion.vo.coupon;

import java.util.List;

import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import lombok.Data;

@Data
public class ProductCouponResponseVo extends BaseResponseVo {
	private String memberNo;
	private List<ProductCouponsVo> productCouponsList;
}
