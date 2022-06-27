package com.plateer.ec1.promotion.vo;

import java.util.List;

import lombok.Data;

@Data
public class ProductCouponsVo {
	private Product product;
	private List<Promotion> promotionList;
}
