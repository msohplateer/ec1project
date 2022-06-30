package com.plateer.ec1.promotion.coupon.service;

import com.plateer.ec1.promotion.coupon.service.impl.CouponCancelServiceImpl;
import com.plateer.ec1.promotion.coupon.service.impl.CouponDownloadServiceImpl;
import com.plateer.ec1.promotion.coupon.service.impl.CouponUseServiceImpl;
import com.plateer.ec1.promotion.vo.coupon.CouponRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CouponService {

    private final CouponDownloadServiceImpl cpnDwlService;

    private final CouponUseServiceImpl cpnUseService;

    private final CouponCancelServiceImpl cpnCnclService;

    public void downloadCoupon(CouponRequestVo vo) throws Exception {
        cpnDwlService.downloadCoupon(vo);
    }

    public void useCoupon(CouponRequestVo vo) throws Exception{
        cpnUseService.useCoupon(vo);
    }

    public void cancelCoupon(CouponRequestVo vo) throws Exception{
        cpnCnclService.cancelCoupon(vo);
    }
}
