package com.plateer.ec1.claim.worker.processor;

import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.vo.ClaimVo;

public interface ClaimProcessor {
	
	public ProcessorType getType();
	public void doProcess(ClaimVo dto);
}
