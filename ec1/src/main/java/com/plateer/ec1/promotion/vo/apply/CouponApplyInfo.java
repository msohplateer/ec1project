package com.plateer.ec1.promotion.vo.apply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponApplyInfo {
    private Long prmNo;
    private String cpnKindCd;
    private String dcCcd;
    private Long dcVal;
    private Long minPurAmt;
    private Long maxDcAmt;
    private String degrCcd;
    private Long cpnIssNo;
    private String orgApplyYn;
    private String mbrNo;
    private Long dcAmt;
    private String maxBenefitYn;
}
