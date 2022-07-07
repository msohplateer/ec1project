package com.plateer.ec1.promotion.vo.base;

import com.plateer.ec1.common.vo.Product;
import lombok.Data;

import java.util.List;

@Data
public class PromotionRequestVo {
	private String memberNo;
	private List<Product> productList;
	private List couponIssueNoList;
}
