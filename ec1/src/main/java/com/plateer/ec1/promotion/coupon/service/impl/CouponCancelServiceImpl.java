package com.plateer.ec1.promotion.coupon.service.impl;

import com.plateer.ec1.common.model.promotion.CcCpnIssue;
import com.plateer.ec1.promotion.mapper.CouponTrxMapper;
import com.plateer.ec1.promotion.mapper.CouponMapper;
import com.plateer.ec1.promotion.validator.CouponValidator;
import com.plateer.ec1.promotion.vo.coupon.Coupon;
import com.plateer.ec1.promotion.vo.coupon.CouponRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponCancelServiceImpl {

    private final CouponValidator validator;
    private final CouponMapper ciMapper;
    private final CouponTrxMapper cdtMapper;

    public void cancelCoupon(CouponRequestVo vo) throws Exception{
        checkRestoreCoupon(vo);
        CcCpnIssue model = CcCpnIssue.builder()
                .prmNo(vo.getPrmNo())
                .mbrNo(vo.getMbrNo())
                .orgCpnIssNo(vo.getCpnIssNo())
                .build();
        cdtMapper.downloadCoupon(model);
    }

    public void checkRestoreCoupon(CouponRequestVo vo) throws Exception{
        Coupon cpnInfo = ciMapper.getCancelCouponInfo(vo);
        validator.checkPrmPeriod(cpnInfo);
    }
}
