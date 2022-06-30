package com.plateer.ec1.promotion.vo.pricediscount;

import java.util.List;

import com.plateer.ec1.promotion.vo.common.Product;
import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import lombok.Data;

@Data
public class PriceDiscountResponseVo extends BaseResponseVo {
	private String memberNo;
	private List<Product> productList;
}
	