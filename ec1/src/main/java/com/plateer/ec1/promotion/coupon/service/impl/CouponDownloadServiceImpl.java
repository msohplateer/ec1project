package com.plateer.ec1.promotion.coupon.service.impl;

import com.plateer.ec1.common.model.promotion.CcCpnIssue;
import com.plateer.ec1.promotion.mapper.CouponTrxMapper;
import com.plateer.ec1.promotion.mapper.CouponMapper;
import com.plateer.ec1.promotion.validator.CouponValidator;
import com.plateer.ec1.promotion.vo.coupon.Coupon;
import com.plateer.ec1.promotion.vo.coupon.CouponRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CouponDownloadServiceImpl {

    private final CouponValidator validator;
    private final CouponMapper ciMapper;
    private final CouponTrxMapper cdtMapper;

    public void downloadCoupon(CouponRequestVo vo) throws Exception{
        Coupon cpnInfo = ciMapper.getAvailableCoupon(vo);
        log.info("----------------------- couponInfo : " + cpnInfo.toString());
        checkAvailableDownload(cpnInfo);
        CcCpnIssue model = CcCpnIssue.builder()
                .prmNo(vo.getPrmNo())
                .mbrNo(vo.getMbrNo())
                .build();
        cdtMapper.downloadCoupon(model);
    }

    private void checkAvailableDownload(Coupon cpnInfo) throws Exception{
        validator.checkDwlPeriod(cpnInfo);
        validator.checkCnt(cpnInfo);
    }


}
