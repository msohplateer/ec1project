package com.plateer.ec1.promotion.calculator.impl;

import com.plateer.ec1.common.vo.Product;
import com.plateer.ec1.promotion.calculator.Calculator;
import com.plateer.ec1.promotion.enums.Prm0004Code;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.mapper.ApplyInfoMapper;
import com.plateer.ec1.promotion.vo.apply.CouponApplyInfo;
import com.plateer.ec1.promotion.vo.apply.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.apply.ProductCouponsVo;
import com.plateer.ec1.promotion.vo.apply.PromotionApplyRequestVo;
import com.plateer.ec1.promotion.vo.base.BaseResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductCouponCalculator implements Calculator{

	private final ApplyInfoMapper aiMapper;

	@Override
	public PromotionType getType() {
		return PromotionType.PRD_CUP;
	}

	@Override
	public BaseResponseVo getCalculationData(PromotionApplyRequestVo reqVo) {
		List<ProductCouponsVo> applyList = getAvailableProductCouponData(reqVo);
		List<ProductCouponsVo> calculateList = calculateData(applyList);
		calculateMaxYn(calculateList);
		return ProductCouponResponseVo.builder()
				.memberNo(reqVo.getMbrNo())
				.productCouponsList(calculateList)
				.build();
	}

	private List<ProductCouponsVo> getAvailableProductCouponData(PromotionApplyRequestVo vo) {
		vo.setCpnKindCd(Prm0004Code.PRD_CPN.getValue());
		List<ProductCouponsVo> applyList = aiMapper.getProductCouponsInfo(vo);
		return applyList;
	}

	private List<ProductCouponsVo> calculateData(List<ProductCouponsVo> pcbData) {
		// 할인금액 계산
		for(ProductCouponsVo baseData:pcbData) {
			for (CouponApplyInfo appData : baseData.getCouponApplyInfoList()) {
				appData.setDcAmt(getDcAmt(baseData.getProduct(), appData));
			}
		}
		return pcbData;
	}

	private void calculateMaxYn(List<ProductCouponsVo> pcbList){
		Set<Long> maxBnfSet = new HashSet<>();
		for(ProductCouponsVo vo:pcbList){
			List<CouponApplyInfo> applyInfoList = vo.getCouponApplyInfoList();
			log.info("applyInfoList data : " + applyInfoList.toString());
			CouponApplyInfo maxPrm = getMaxPrm(applyInfoList, maxBnfSet);
			if(maxPrm != null) {
				maxBnfSet.add(maxPrm.getCpnIssNo());
				maxPrm.setMaxBenefitYn("Y");
			}
		}
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


	private Long getDcAmt(Product product, CouponApplyInfo baseData){
		Long dcAmt = 0L;
		// 최소구매금액 체크
		if(product.getGoodsAmt() < baseData.getMinPurAmt()){ return 0L;}
		return baseData.getDcCcd().equals("10")?getFixedAmt(product, baseData):getRateAmt(product, baseData);
	}

	private Long getRateAmt(Product product, CouponApplyInfo baseData){
		Long dcAmt = product.getGoodsAmt() * baseData.getDcVal() / 100;
		return dcAmt <= baseData.getMaxDcAmt()?dcAmt:baseData.getMaxDcAmt();
	}

	private Long getFixedAmt(Product product, CouponApplyInfo baseData){
		return baseData.getDcVal() <= baseData.getMaxDcAmt()?baseData.getDcVal():baseData.getMaxDcAmt();
	}
}
