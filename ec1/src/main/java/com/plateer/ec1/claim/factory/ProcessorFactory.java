package com.plateer.ec1.claim.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.plateer.ec1.claim.enums.ClaimType;
import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.vo.ClaimVo;
import com.plateer.ec1.claim.worker.processor.ClaimProcessor;
import com.plateer.ec1.common.code.product.ProductType;
import com.plateer.ec1.order.enums.OrderClaimType;

@Component
public class ProcessorFactory {
	
	Map<ProcessorType, ClaimProcessor> factoryMap = new HashMap<>();
	
	public ProcessorFactory(List<ClaimProcessor> processorList) {
		processorList.forEach(c -> factoryMap.put(c.getType(), c));
	}
	
	public ClaimProcessor getProcessor(ClaimVo Vo) {
		ProcessorType type = 
				ClaimType.findClaimtypeByVo(OrderClaimType.getOrderClaimTypeByName(Vo.getOrderClaimType()), ProductType.getProductTypeByName(Vo.getProductType())).getProcessorType();
		return factoryMap.get(type);
	}
	
}
