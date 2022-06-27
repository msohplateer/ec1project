package com.plateer.ec1.claim.worker.validator;

import com.plateer.ec1.claim.enums.ValidatorType;
import com.plateer.ec1.claim.vo.ClaimVo;

public interface ClaimValidator {
	
	public ValidatorType getType();
	public void validate(ClaimVo dto);
}
