package com.plateer.ec1.payment.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InicisGetVrAcctNoResVo {
    private String resultCode;
    private String resultMsg;
    private String tid;
    private String authDate;
    private String authTime;
    private String vacct;
    private String vacctName;
    private String vacctBankCode;
    private String validDate;
    private String validTime;
    private String price;
}
