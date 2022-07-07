package com.plateer.ec1.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Product {
	private String goodsNo;
	private int goodsAmt;
	private String goodsItemNo;
	private int goodsCnt;
	private Long prmNo;
	private Long cpnIssNo;
}
