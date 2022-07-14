package com.plateer.ec1.payment.mapper;

import com.plateer.ec1.common.model.payment.OpPayInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentTrxMapper {
    int insertRequestHistory(OpPayInfo poPayInfo);
}
