package com.plateer.ec1.promotion.mapper;


import com.plateer.ec1.common.model.promotion.CcCpnIssue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponTrxMapper {
    int downloadCoupon(CcCpnIssue model);

    int useCoupon(CcCpnIssue model);
}
