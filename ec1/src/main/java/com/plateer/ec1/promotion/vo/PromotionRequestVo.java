package com.plateer.ec1.promotion.vo;

import java.util.List;

import lombok.Data;

@Data
public class PromotionRequestVo {
	private String memberNo;
	private List<Product> productList;
	private List couponIssueNoList;
}
