package com.plateer.ec1.promotion.vo.apply;

import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class CartCouponResponseVo extends BaseResponseVo {
	private String memberNo;
	private List<CouponProductsVo> couponProductsList;

}
