package com.plateer.ec1.common.model.promotion;

import com.plateer.ec1.common.model.BaseModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CcCpnBase extends BaseModel {
    private Long prmNo;
    private String cpnKindCd;
    private String degrCcd;
    private String dcSvCcd;
    private String mdaGb;
    private String entChnGb;
    private String dwlAvlStrtDd;
    private String dwlAvlEndDd;
    private int dwlPsbCnt;
    private int psnDwlPsbCnt;
    private String dwlAvlPlc;
    private String issWayCcd;
    private String certCd;
    private double ourChrgRt;
    private double entrChrgRt;

}
