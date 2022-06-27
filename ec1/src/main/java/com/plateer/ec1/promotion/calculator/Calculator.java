package com.plateer.ec1.promotion.calculator;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.BaseResponseVo;
import com.plateer.ec1.promotion.vo.PromotionRequestVo;

public interface Calculator {
	PromotionType getType();
	public BaseResponseVo getCalculationData(PromotionRequestVo prVo);
}
