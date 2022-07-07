package com.plateer.ec1.promotion.vo.pricediscount;

import com.plateer.ec1.common.vo.Product;
import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class PriceDiscountResponseVo extends BaseResponseVo {
	private String memberNo;
	private List<Product> productList;

}
	