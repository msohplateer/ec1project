package com.plateer.ec1.promotion.coupon.service.impl;

import com.plateer.ec1.common.model.promotion.CcCpnIssueModel;
import com.plateer.ec1.promotion.mapper.CouponUseTrxMapper;
import com.plateer.ec1.promotion.vo.coupon.CouponRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponUseServiceImpl {

    private final CouponUseTrxMapper cutMapper;

    public void useCoupon(CouponRequestVo vo) throws Exception{
        CcCpnIssueModel model = CcCpnIssueModel.builder()
                .cpnIssNo(vo.getCpnIssNo())
                .ordNo(vo.getOrdNo())
                .build();
        cutMapper.useCoupon(model);
    }

}
