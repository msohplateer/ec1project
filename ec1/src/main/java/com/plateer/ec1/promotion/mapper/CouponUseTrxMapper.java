package com.plateer.ec1.promotion.mapper;


import com.plateer.ec1.common.model.promotion.CcCpnIssueModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponUseTrxMapper {
    int useCoupon(CcCpnIssueModel model);
}