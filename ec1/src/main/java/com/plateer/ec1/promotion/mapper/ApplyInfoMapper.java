package com.plateer.ec1.promotion.mapper;

import com.plateer.ec1.promotion.vo.apply.CouponProductsVo;
import com.plateer.ec1.promotion.vo.apply.ProductCouponsVo;
import com.plateer.ec1.promotion.vo.apply.PromotionApplyRequestVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyInfoMapper {
    List<ProductCouponsVo> getProductCouponsInfo(PromotionApplyRequestVo vo);

    List<CouponProductsVo> getCouponProductsInfo(PromotionApplyRequestVo vo);
}
