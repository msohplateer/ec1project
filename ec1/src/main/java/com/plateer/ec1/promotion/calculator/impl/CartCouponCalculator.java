package com.plateer.ec1.promotion.calculator.impl;

import com.plateer.ec1.common.vo.Product;
import com.plateer.ec1.promotion.calculator.Calculator;
import com.plateer.ec1.promotion.enums.Prm0003Code;
import com.plateer.ec1.promotion.enums.Prm0004Code;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.mapper.ApplyInfoMapper;
import com.plateer.ec1.promotion.vo.apply.*;
import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class CartCouponCalculator implements Calculator{

	private final ApplyInfoMapper aiMapper;
	@Override
	public PromotionType getType() {
		return PromotionType.CART_CUP;
	}

	@Override
	public BaseResponseVo getCalculationData(PromotionApplyRequestVo reqVo) {
		List<CouponProductsVo> cpList = getAvailablePromotionData(reqVo);
		log.info("couponProducts List : " + cpList.toString());
		List<CouponProductsVo> calculateList = calculateDcAmt(cpList);
		calculateMaxYn(calculateList);
		return CartCouponResponseVo.builder()
				.memberNo(reqVo.getMbrNo())
				.couponProductsList(calculateList)
				.build();
	}

	private void calculateMaxYn(List<CouponProductsVo> cpList){
		CouponApplyInfo caInfo = cpList.stream()
				.map(d -> d.getCouponApplyInfo())
				.collect(Collectors.toList())
				.stream()
				.max(Comparator.comparing(CouponApplyInfo::getDcAmt)
						.thenComparing(CouponApplyInfo::getPrmNo).reversed()
						.thenComparing(CouponApplyInfo::getCpnIssNo).reversed())
				.orElse(CouponApplyInfo.builder().build() );
		caInfo.setMaxBenefitYn("Y");
	}

	private CouponApplyInfo getMaxPrm(List<CouponApplyInfo> paList, Set<Long> maxBnfSet) {
		log.info("List Data : " + paList.toString());
		CouponApplyInfo vo = paList.stream()
				.filter(data -> !maxBnfSet.contains(data.getCpnIssNo()) && data.getDcAmt() > 0)
				.max(Comparator.comparing(CouponApplyInfo::getDcAmt)
						.thenComparing(CouponApplyInfo::getPrmNo).reversed()
						.thenComparing(CouponApplyInfo::getCpnIssNo).reversed())
				.orElse(CouponApplyInfo.builder().build() );
		return vo;
	}



	private List<CouponProductsVo> calculateDcAmt(List<CouponProductsVo> cpList) {
		// 할인금액 계산
		for (CouponProductsVo cpData : cpList) {
			cpData.getCouponApplyInfo().setDcAmt(getDcAmt(cpData.getCouponApplyInfo(), cpData.getProductList()));
		}
		return cpList;
	}

	private Long getDcAmt(CouponApplyInfo cpnInfo, List<Product> prdList){
		return cpnInfo.getDcCcd().equals(Prm0003Code.DC_AMT)?getFixedAmt(cpnInfo, prdList):getRateAmt(cpnInfo, prdList);
	}

	private Long getFixedAmt(CouponApplyInfo cpnInfo, List<Product> prdList){
		Long goodsSum = 0L;

		for(Product product : prdList){
			goodsSum += product.getGoodsAmt();
		}

		return goodsSum < cpnInfo.getMinPurAmt()?0l:cpnInfo.getDcVal();
	}

	private Long getRateAmt(CouponApplyInfo cpnInfo, List<Product> prdList){
		Long goodsSum = 0L;
		Long dcAmt = 0L;

		for(Product product : prdList){
			goodsSum += product.getGoodsAmt();
		}
		if(goodsSum < cpnInfo.getMinPurAmt()) return 0L;

		dcAmt = goodsSum * cpnInfo.getDcVal() / 100;

		return dcAmt <= cpnInfo.getMaxDcAmt()?dcAmt:cpnInfo.getMaxDcAmt();
	}

	private List<CouponProductsVo> getAvailablePromotionData(PromotionApplyRequestVo reqVo) {
		reqVo.setCpnKindCd(Prm0004Code.CART_CPN.getValue());
		List<CouponProductsVo> cpList = aiMapper.getCouponProductsInfo(reqVo);
		return cpList;
	}

}
