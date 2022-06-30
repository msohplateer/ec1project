package com.plateer.ec1.promotion.vo.coupon;

import com.plateer.ec1.promotion.vo.common.Product;
import lombok.Data;

import java.util.List;

@Data
public class CouponProductsVo {
	private Coupon coupon;
	private List<Product> productList;
}
