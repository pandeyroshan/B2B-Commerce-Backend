package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.BusinessId;
import in.rakuten.b2bcommerce.dto.OrderSummaryDetail;
import in.rakuten.b2bcommerce.model.OrderSummary;
import in.rakuten.b2bcommerce.model.PurchaseDetail;
import in.rakuten.b2bcommerce.service.OrderSummaryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
	@Autowired
	OrderSummaryService orderSummaryService;
	
	@PostMapping("/place-order")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public Integer placeOrder(@RequestBody OrderSummaryDetail orderSummaryDetail) {
		return orderSummaryService.placeOrder(orderSummaryDetail);
	}
	
	@PostMapping("/my-orders")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public List<OrderSummary> getMyOrders(@RequestBody BusinessId businessId) {
		return this.orderSummaryService.getMyOrders(businessId.getBusinessId());
	}
	
	@GetMapping("/cancel-order/{order_id}")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public void cancelOrder(@PathVariable("order_id") Integer orderId) {
		orderSummaryService.cancelOrder(orderId);
	}
	
	@GetMapping("/order-details/{order_id}")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public OrderSummary getOrderDetails(@PathVariable("order_id") Integer orderId) {
		return orderSummaryService.getOrderSummary(orderId);
	}
	
	@GetMapping("/purchase-details/{order_id}")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public List<PurchaseDetail> getPurchaseDetails(@PathVariable("order_id") Integer orderId) {
		return orderSummaryService.getPurchaseDetailByOrderId(orderId);
	}
}
