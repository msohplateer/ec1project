package com.plateer.ec1.promotion.coupon.service.impl;

import com.plateer.ec1.common.model.promotion.CcCpnIssueModel;
import com.plateer.ec1.promotion.mapper.CouponDownloadTrxMapper;
import com.plateer.ec1.promotion.mapper.CouponInfoMapper;
import com.plateer.ec1.promotion.validator.CouponValidator;
import com.plateer.ec1.promotion.vo.coupon.Coupon;
import com.plateer.ec1.promotion.vo.coupon.CouponRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponCancelServiceImpl {

    private final CouponValidator validator;
    private final CouponInfoMapper ciMapper;
    private final CouponDownloadTrxMapper cdtMapper;

    public void cancelCoupon(CouponRequestVo vo) throws Exception{
        checkRestoreCoupon(vo);
        CcCpnIssueModel model = CcCpnIssueModel.builder()
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
