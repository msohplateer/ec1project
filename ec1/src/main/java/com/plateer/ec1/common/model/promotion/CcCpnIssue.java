package com.plateer.ec1.common.model.promotion;

import com.plateer.ec1.common.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CcCpnIssue extends BaseModel {
    private Long prmNo;
    private Long cpnIssNo;
    private String mbrNo;
    private LocalDateTime cpnUseDt;
    private Long orgCpnIssNo;
    private String cpnCertNo;
    private String ordNo;
}
