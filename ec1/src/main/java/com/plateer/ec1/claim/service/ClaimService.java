package com.plateer.ec1.claim.service;

import org.springframework.stereotype.Service;

import com.plateer.ec1.claim.factory.ProcessorFactory;
import com.plateer.ec1.claim.vo.ClaimVo;
import com.plateer.ec1.claim.worker.processor.ClaimProcessor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClaimService {
	
	private final ProcessorFactory factory;
	
	public void claim(ClaimVo vo) {
		ClaimProcessor claimProcessor = factory.getProcessor(vo);
		claimProcessor.doProcess(vo);
	}
}
