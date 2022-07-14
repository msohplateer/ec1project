package com.plateer.ec1.payment.service.impl;

import com.plateer.ec1.common.model.payment.OpPayInfo;
import com.plateer.ec1.payment.enums.*;
import com.plateer.ec1.payment.mapper.PaymentTrxMapper;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.*;
import com.plateer.ec1.util.ConnectionUtil;
import com.plateer.ec1.util.ConvertUtil;
import com.plateer.ec1.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
@RequiredArgsConstructor
public class InicisPaymentServiceImpl implements PaymentService{
	//private final ConnectionUtil connectionUtil;
	private final PaymentTrxMapper paymentTrxMapper;


	@Override
	public PaymentType getType() {
		return PaymentType.INICIS;
	}

	@Override
	@Transactional
	public PayApproveResVo approvePay(PayInfoVo payInfoVo, OrderInfoVo orderInfoVo) throws Exception {
		InicisGetVrAcctNoResVo resVo = requestApprove(payInfoVo, orderInfoVo);
		insertRequestHistory(resVo, orderInfoVo);
		return new PayApproveResVo();
	}


	@Override
	public void cancelPay(OriginalOrderVo originalOrderVo) {

	}

	@Override
	public void netCancel(NetCancelReqVo netCancelReqVo) {

	}

	private InicisGetVrAcctNoResVo requestApprove(PayInfoVo payInfoVo, OrderInfoVo orderInfoVo) throws Exception{
		InicisGetVrAcctNoReqVo reqVo = getPaymentRequestData(payInfoVo, orderInfoVo);
		String resData = ConnectionUtil.httpRequest(InicisData.URL.getCode(), InicisData.GET_NO_PATH.getCode(), reqVo);
		InicisGetVrAcctNoResVo resVo = ConvertUtil.convertJsonToVo(resData, InicisGetVrAcctNoResVo.class);
		return resVo;
	}

	@Transactional
	private void insertRequestHistory(InicisGetVrAcctNoResVo resVo, OrderInfoVo orderInfoVo){
		LocalDateTime ldt = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").parse(resVo.getAuthDate().concat(resVo.getAuthTime())));
		Timestamp payCmtDtime = Timestamp.valueOf(ldt);
		OpPayInfo opPayInfo = OpPayInfo.builder()
				.payNo("S" +  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
				.ordNo(orderInfoVo.getOrdNo())
				.payMnCd(Opt0009Code.VR_ACCT.getCode())
				.payCcd(Opt0010Code.PAYMENT.getCode())
				.payPrgsScd(Opt0011Code.PAYMENT_REQUEST.getCode())
				.payAmt(Long.parseLong(resVo.getPrice()))
				.cnclAmt(0L)
				.rfndAvlAmt(Long.parseLong(resVo.getPrice()))
				.trsnId(resVo.getTid())
				.payCmtDtime(payCmtDtime)
				.vrAcct(resVo.getVacct())
				.vrAcctNm(resVo.getVacctName())
				.vrBnkCd(resVo.getVacctBankCode())
				.vrValDt(resVo.getValidDate())
				.vrValTt(resVo.getValidTime())
				.build();

		paymentTrxMapper.insertRequestHistory(opPayInfo);
	}


	private String getTimeStamp(LocalDateTime now){
		return now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	}

	private String getDtInput(LocalDateTime now){
		return now.plusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	private String getTmInput(LocalDateTime now){
		return now.plusDays(1).format(DateTimeFormatter.ofPattern("HHmm"));
	}

	private String getClientIp() {
		try{
			return InetAddress.getLocalHost().getHostAddress();
		}catch (UnknownHostException e){
			try {
				throw new Exception(e.getMessage());
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
	}


	public InicisGetVrAcctNoReqVo getPaymentRequestData(PayInfoVo payInfoVo, OrderInfoVo orderInfoVo) throws Exception {
		LocalDateTime now = LocalDateTime.now();

		StringBuilder sb = new StringBuilder();
		sb.append(InicisData.API_KEY.getCode());
		sb.append(InicisData.TYPE.getCode());
		sb.append(InicisData.PAYMETHOD.getCode());
		sb.append(getTimeStamp(now));
		sb.append(getClientIp());
		sb.append(InicisData.MID.getCode());
		sb.append(orderInfoVo.getOrdNo());
		sb.append(String.valueOf(payInfoVo.getPaymentAmount()));

		String hashData = EncryptUtil.getEncryptData(sb.toString());

		return InicisGetVrAcctNoReqVo.builder()
				.type(InicisData.TYPE.getCode())
				.paymethod(InicisData.PAYMETHOD.getCode())
				.timestamp(getTimeStamp(now))
				.clientIp(getClientIp())
				.mid(InicisData.MID.getCode())
				.url(InicisData.SUB_URL.getCode())
				.moid(orderInfoVo.getOrdNo())
				.goodName(orderInfoVo.getGoodName())
				.buyerName(orderInfoVo.getBuyerName())
				.buyerEmail(orderInfoVo.getBuyerEmail())
				.buyerTel(orderInfoVo.getTelNo())
				.price(payInfoVo.getStringPaymentAmount())
				.currency(InicisData.CURRENCY.getCode())
				.bankCode(payInfoVo.getBankCode())
				.dtInput(getDtInput(now))
				.tmInput(getTmInput(now))
				.nmInput(payInfoVo.getDepositorName())
				.hashData(hashData)
				.build();
	}
}
