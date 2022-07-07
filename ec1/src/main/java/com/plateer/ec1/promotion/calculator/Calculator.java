package com.plateer.ec1.promotion.calculator;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.apply.PromotionApplyRequestVo;
import com.plateer.ec1.promotion.vo.base.BaseResponseVo;

public interface Calculator {
	PromotionType getType();
	public BaseResponseVo getCalculationData(PromotionApplyRequestVo reqVo);
}
