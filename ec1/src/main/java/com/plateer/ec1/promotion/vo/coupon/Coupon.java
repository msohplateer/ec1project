package com.plateer.ec1.promotion.vo.coupon;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Coupon {
    private Long prmNo;
    private String prmNm;
    private int dwlPsbCnt;
    private int psnDwlPsbCnt;
    private int dwlCptCnt;
    private int psnDwlCptCnt;
    private LocalDateTime prmStrtDt;
    private LocalDateTime prmEndDt;
    private LocalDate dwlAvlStrtDd;
    private LocalDate dwlAvlEndDd;
    private String cpnKindCd;
    private Long cpnIssNo;
    private String degrCcd;
    private Long dcAmt;
    private String maxBenefitYn;
}
