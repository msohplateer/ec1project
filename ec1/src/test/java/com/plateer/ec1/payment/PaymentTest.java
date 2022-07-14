package com.plateer.ec1.payment;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.service.impl.InicisPaymentServiceImpl;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentTest {

    @Autowired
    InicisPaymentServiceImpl service;

    @Test
    @DisplayName("결제 인터페이스 테스트")
    void if_test() throws Exception {
        PayInfoVo payInfoVo = PayInfoVo.builder()
                .depositorName("OMS")
                .paymentType(PaymentType.INICIS)
                .bankCode("03")
                .paymentAmount(10000L)
                .build();

        OrderInfoVo orderInfoVo = OrderInfoVo.builder()
                .buyerEmail("oms@naver.com")
                .goodName("testPrd")
                .ordNo("O123456")
                .telNo("01012341234")
                .buyerName("oms")
                .build();
        service.approvePay(payInfoVo, orderInfoVo);
    }
}
