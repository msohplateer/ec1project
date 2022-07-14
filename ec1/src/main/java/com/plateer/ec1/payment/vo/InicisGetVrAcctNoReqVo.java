package com.plateer.ec1.payment.vo;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InicisGetVrAcctNoReqVo {
    private String type = "Pay";
    private String paymethod = "Vacct";
    private String timestamp;
    private String clientIp;
    private String mid;
    private String url;
    private String moid;
    private String goodName;
    private String buyerName;
    private String buyerEmail;
    private String buyerTel;
    private String price;
    private String currency;
    private String bankCode;
    private String dtInput;
    private String tmInput;
    private String nmInput;
    private String hashData;
}
