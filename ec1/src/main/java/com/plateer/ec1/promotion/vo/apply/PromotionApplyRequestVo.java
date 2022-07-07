package com.plateer.ec1.promotion.vo.apply;

import com.plateer.ec1.common.vo.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PromotionApplyRequestVo {
	private String mbrNo;
	private String cpnKindCd;
	private List<Product> productList;
}
