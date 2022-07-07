package com.plateer.ec1.promotion.vo.apply;

import com.plateer.ec1.common.vo.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCouponsVo {
	private Product product;
	private List<CouponApplyInfo> couponApplyInfoList;
}
