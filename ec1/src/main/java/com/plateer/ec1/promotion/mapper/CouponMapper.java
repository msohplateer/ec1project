package com.plateer.ec1.promotion.mapper;

import com.plateer.ec1.promotion.vo.coupon.Coupon;
import com.plateer.ec1.promotion.vo.coupon.CouponRequestVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {
    Coupon getAvailableCoupon(CouponRequestVo vo);

    Coupon getCancelCouponInfo(CouponRequestVo vo);
}
