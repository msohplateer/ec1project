package com.plateer.ec1.common.model.promotion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CcCpnIssueModel {
    private Long prmNo;
    private Long cpnIssNo;
    private String mbrNo;
    private LocalDateTime cpnUseDt;
    private Long orgCpnIssNo;
    private String cpnCertNo;
    private String ordNo;
    private LocalDateTime sysRegDtime;
    private String sysRegId;
    private LocalDateTime sysModDtime;
    private String sysModrId;
}
