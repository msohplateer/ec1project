package com.plateer.ec1.promotion.vo.apply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCouponBaseDataVo {
    private Long prmNo;
    private String prmNm;
    private String dcCcd;
    private Long dcVal;
    private int minPurAmt;
    private Long maxDcAmt;
    private String cpnKindCd;
    private String degrCcd;
    private Long cpnIssNo;
    private String mbrNo;
    private String goodsNo;
    private String itemNo;
    private Long goodsAmt;
    private Long dcAmt;
    private String maxBenefitYn;
}
