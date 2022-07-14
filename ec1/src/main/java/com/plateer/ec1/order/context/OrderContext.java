package com.plateer.ec1.order.context;

import com.plateer.ec1.order.repository.OrderRepository;
import com.plateer.ec1.order.service.OrderHistoryService;
import com.plateer.ec1.order.strategy.after.AfterStrategy;
import com.plateer.ec1.order.strategy.data.DataCreateStrategy;
import com.plateer.ec1.order.validator.OrderValidator;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.OrderRequest;
import com.plateer.ec1.order.vo.OrderValidationVo;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.payment.service.PayService;

import java.util.Arrays;

public class OrderContext {
	private OrderHistoryService orderHistoryService;
	private PayService payService;
	private OrderRepository orderRepository;
	
	public OrderContext(OrderHistoryService orderHistoryService, PayService payService, OrderRepository orderRepository) {
		this.orderHistoryService = orderHistoryService;
		this.payService = payService;
		this.orderRepository = orderRepository;
	}
	
	public void execute(DataCreateStrategy dcStrategy, AfterStrategy aStrategy, OrderRequest request) {
		Long historyNo = orderHistoryService.insertOrderHistory(request);
		OrderVo Vo = null;
		
		// validation
		OrderValidator.get(request).test(new OrderValidationVo(request, Arrays.asList(new OrderProductView())));
		
		// 데이터 생성
		Vo = dcStrategy.create(request, (OrderProductView) Arrays.asList(new OrderProductView()));
		
		// 주문 데이터 입력
		insertOrderData(Vo);
		
		// 결제 처리
		//payService.approvePayment(request.getPayInfoVo());
		
		// 금액 검증
		amountValidation(request.getOrderNo());
		
		// 후처리
		aStrategy.call(request, Vo);
	}
	
	private void insertOrderData(OrderVo Vo) {
		orderRepository.insertOrderBase(Vo);
		orderRepository.insertOrderProduct(Vo);
		orderRepository.insertOrderClaim(Vo);
	}
	
	private void amountValidation(String orderNo) {
		
	}
}
