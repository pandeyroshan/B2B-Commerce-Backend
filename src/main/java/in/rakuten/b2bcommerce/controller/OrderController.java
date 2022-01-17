package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.OrderSummaryDetail;
import in.rakuten.b2bcommerce.model.OrderSummary;
import in.rakuten.b2bcommerce.model.PurchaseDetail;
import in.rakuten.b2bcommerce.service.OrderSummaryService;

@RestController
public class OrderController {
	
	@Autowired
	OrderSummaryService orderSummaryService;
	
	@PostMapping("/place-order")
	public Integer placeOrder(@RequestBody OrderSummaryDetail orderSummaryDetail) {
		Integer placeOrderId = orderSummaryService.placeOrder(orderSummaryDetail);
		
		return placeOrderId;
	}
	
	@GetMapping("/cancel-order/{order_id}")
	public void cancelOrder(@PathVariable("order_id") Integer orderId) {
		orderSummaryService.cancelOrder(orderId);
	}
	
	@GetMapping("/order-details/{order_id}")
	public OrderSummary getOrderDetails(@PathVariable("order_id") Integer orderId) {
		OrderSummary orderSummary = orderSummaryService.getOrderSummary(orderId);
		return orderSummary;
	}
	
	@GetMapping("/purchase-details/{order_id}")
	public List<PurchaseDetail> getPurchaseDetails(@PathVariable("order_id") Integer orderId) {
		List<PurchaseDetail> purchaseDetailByOrderId = orderSummaryService.getPurchaseDetailByOrderId(orderId);
		return purchaseDetailByOrderId;
	}
}
