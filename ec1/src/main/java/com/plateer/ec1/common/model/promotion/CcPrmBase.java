package com.plateer.ec1.common.model.promotion;

import com.plateer.ec1.common.model.BaseModel;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CcPrmBase extends BaseModel {
    private Long prmNo;
    private String prmNm;
    private String prmKindCd;
    private String prmPriodCcd;
    private Timestamp prmStrtDt;
    private Timestamp prmEndDt;
    private int prmStdDd;
    private String empYn;
    private String dcCcd;
    private double dcVal;
    private int minPurAmt;
    private int maxDcAmt;
    private String useYn;
    private String rmk;
}
