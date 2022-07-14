package com.plateer.ec1.promotion.coupon.service.impl;

import com.plateer.ec1.common.model.promotion.CcCpnIssue;
import com.plateer.ec1.promotion.mapper.CouponTrxMapper;
import com.plateer.ec1.promotion.vo.coupon.CouponRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponUseServiceImpl {

    private final CouponTrxMapper cutMapper;

    public void useCoupon(CouponRequestVo vo) throws Exception{
        CcCpnIssue model = CcCpnIssue.builder()
                .cpnIssNo(vo.getCpnIssNo())
                .ordNo(vo.getOrdNo())
                .build();
        cutMapper.useCoupon(model);
    }

}
