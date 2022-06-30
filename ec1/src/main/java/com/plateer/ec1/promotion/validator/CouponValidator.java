package com.plateer.ec1.promotion.validator;

import com.plateer.ec1.promotion.enums.PromotionException;
import com.plateer.ec1.promotion.vo.coupon.Coupon;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CouponValidator {

    public void checkPrmPeriod(Coupon cpnInfo) throws Exception{
        if(LocalDateTime.now().isBefore(cpnInfo.getPrmEndDt())){
            throw new Exception(PromotionException.CPN_CANCEL_PERIOD_EXCEPTION.getMSG());
        }
        return;
    }

    public void checkDwlPeriod(Coupon cpnInfo) throws Exception{
        if(LocalDate.now().isAfter(cpnInfo.getDwlAvlEndDd()) ||
                LocalDate.now().isBefore(cpnInfo.getDwlAvlStrtDd())){
            throw new Exception(PromotionException.CPN_DWL_PERIOD_EXCEPTION.getMSG());
        }
        return;
    }

    public void checkCnt(Coupon cpnInfo) throws Exception {
        if((cpnInfo.getDwlPsbCnt() != 0 &&cpnInfo.getDwlPsbCnt() <= cpnInfo.getDwlCptCnt()) ||
                (cpnInfo.getPsnDwlPsbCnt() != 0 && cpnInfo.getPsnDwlPsbCnt() <= cpnInfo.getPsnDwlCptCnt())){
            throw new Exception(PromotionException.CPN_DWL_COUNT_EXCEPTION.getMSG());
        }
        return;
    }
}
