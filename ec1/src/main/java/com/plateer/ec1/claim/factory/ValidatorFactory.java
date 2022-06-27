package com.plateer.ec1.claim.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.plateer.ec1.claim.enums.ValidatorType;
import com.plateer.ec1.claim.worker.validator.ClaimValidator;

@Component
public class ValidatorFactory {
	
	Map<ValidatorType, ClaimValidator> factoryMap = new HashMap<>();
	
	public ValidatorFactory(List<ClaimValidator> validatorList) {
		validatorList.forEach(c -> factoryMap.put(c.getType(), c));
	}
	
	public ClaimValidator getValidator(ValidatorType type) {
		return factoryMap.get(type);
	}
}
