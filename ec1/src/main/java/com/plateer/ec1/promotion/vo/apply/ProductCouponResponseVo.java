package com.plateer.ec1.promotion.vo.apply;

import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class ProductCouponResponseVo extends BaseResponseVo {
	private String memberNo;
	private List<ProductCouponsVo> productCouponsList;

}
