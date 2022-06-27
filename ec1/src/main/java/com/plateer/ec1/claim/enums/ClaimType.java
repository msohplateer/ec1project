package com.plateer.ec1.claim.enums;

import java.util.Arrays;
import java.util.List;

import com.plateer.ec1.common.code.product.ProductType;
import com.plateer.ec1.order.enums.OrderClaimType;
import com.plateer.ec1.order.enums.OrderProcessStateType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ClaimType {
	GCC(ProcessorType.CPT, OrderClaimType.C, ValidatorType.CNL, Arrays.asList(OrderProcessStateType.OS, OrderProcessStateType.OC), Arrays.asList(ProductType.GP), true), // 일반상품취소완료
	MCA(ProcessorType.ACW, OrderClaimType.C, ValidatorType.CNL, Arrays.asList(OrderProcessStateType.OC), Arrays.asList(ProductType.MC), true), // 모바일쿠폰취소접수
	RA(ProcessorType.CPT, OrderClaimType.R, ValidatorType.RTX, Arrays.asList(OrderProcessStateType.RA), Arrays.asList(ProductType.GP, ProductType.MC), true), // 반품접수
	RW(ProcessorType.CPT, OrderClaimType.RC, ValidatorType.RTX, Arrays.asList(OrderProcessStateType.RA), Arrays.asList(ProductType.GP, ProductType.MC), false), // 반품철회
	EA(ProcessorType.CPT, OrderClaimType.X, ValidatorType.WDW, Arrays.asList(OrderProcessStateType.EA), Arrays.asList(ProductType.GP, ProductType.MC), true); // 교환접수 
	
	private final ProcessorType processorType;
	private final OrderClaimType orderClaimType;
	private final ValidatorType validatorType;
	private final List<OrderProcessStateType> orderProcessStateTypes;
	private final List<ProductType> productTypes;
	private final Boolean claimNoFlag;
	
	public static ClaimType findClaimtypeByVo(OrderClaimType orderClaimType, ProductType productType) {
		return Arrays.stream(ClaimType.values())
				.filter(t -> t.getOrderClaimType().equals(orderClaimType) && t.getProductTypes().contains(productType))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(""));
	}
}
