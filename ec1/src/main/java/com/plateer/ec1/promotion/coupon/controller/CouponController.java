package com.plateer.ec1.promotion.coupon.controller;

import com.plateer.ec1.promotion.coupon.service.CouponService;
import com.plateer.ec1.promotion.vo.coupon.CouponRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotion/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService service;

    @PostMapping("/download")
    public void couponDownload(@RequestBody CouponRequestVo vo) throws Exception{
        service.downloadCoupon(vo);
    }

    @PostMapping("/use")
    public void couponUse(@RequestBody CouponRequestVo vo) throws Exception{
        service.useCoupon(vo);
    }

    @PostMapping("/cancel")
    public void couponCancel(@RequestBody CouponRequestVo vo) throws Exception{
        service.cancelCoupon(vo);
    }

}
