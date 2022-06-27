package com.plateer.ec1.promotion.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.plateer.ec1.promotion.calculator.Calculator;
import com.plateer.ec1.promotion.enums.PromotionType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CalculatorFactory {
	
	private Map<PromotionType, Calculator> calculatorMap = new HashMap<>();
	private final List<Calculator> calculators;
	
	public CalculatorFactory(List<Calculator> calculators) {
		this.calculators = calculators;
		calculators.forEach(c -> calculatorMap.put(c.getType(), c));
	}
	
	public Calculator getPromotionCalculationData(PromotionType type) {
		return calculatorMap.get(type);
	}
	
	
}
