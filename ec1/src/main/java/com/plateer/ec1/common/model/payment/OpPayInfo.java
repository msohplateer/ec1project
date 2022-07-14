package com.plateer.ec1.common.model.payment;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpPayInfo {
    @NotNull
    private String payNo;
    @NotNull
    private String ordNo;
    private String clmNo;
    @NotNull
    private String payMnCd;
    @NotNull
    private String payCcd;
    @NotNull
    private String payPrgsScd;
    @NotNull
    private Long payAmt;
    @NotNull
    private Long cnclAmt;
    @NotNull
    private Long rfndAvlAmt;
    private String trsnId;
    private Timestamp payCmtDtime;
    private String orgPayNo;
    private String vrAcct;
    private String vrAcctNm;
    private String vrBnkCd;
    private String vrValDt;
    private String vrValTt;
    @NotNull
    private Timestamp sysRegDtime;
    @NotNull
    private String sysRegrId;
    @NotNull
    private Timestamp sysModDtime;
    @NotNull
    private String sysModrId;

}
