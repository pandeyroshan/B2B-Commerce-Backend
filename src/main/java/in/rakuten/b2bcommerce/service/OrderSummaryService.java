package in.rakuten.b2bcommerce.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rakuten.b2bcommerce.dto.OrderSummaryDetail;
import in.rakuten.b2bcommerce.enums.OrderStatus;
import in.rakuten.b2bcommerce.model.Address;
import in.rakuten.b2bcommerce.model.Business;
import in.rakuten.b2bcommerce.model.Cart;
import in.rakuten.b2bcommerce.model.CartProduct;
import in.rakuten.b2bcommerce.model.OrderSummary;
import in.rakuten.b2bcommerce.model.PurchaseDetail;
import in.rakuten.b2bcommerce.repository.AddressRepository;
import in.rakuten.b2bcommerce.repository.BusinessRepository;
import in.rakuten.b2bcommerce.repository.CartProductRepository;
import in.rakuten.b2bcommerce.repository.CartRepository;
import in.rakuten.b2bcommerce.repository.OrderSummaryRepository;
import in.rakuten.b2bcommerce.repository.PurchaseDetailRepository;

@Service
public class OrderSummaryService {
	@Autowired
	OrderSummaryRepository orderSummaryRepository;
	
	@Autowired
	BusinessRepository businessRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	CartProductRepository cartProductRepository;
	
	@Autowired
	CartProductService cartProdcutService;
	
	@Autowired
	PurchaseDetailRepository purchaseDetailRepository;
	
	public Integer placeOrder(OrderSummaryDetail orderSummaryDetail) {
		Cart cart = cartRepository.getById(orderSummaryDetail.getCartId());
		Address address = addressRepository.getById(orderSummaryDetail.getAddressId());
		
		Business business = businessRepository.findByUserId(cart.getUser().getId());
		
		Double totalCost = (double) 0;
		
		List<CartProduct> allCartProductInCart = cartProductRepository.getAllCartProductInCart(cart.getId());
		
		for(CartProduct cartProduct: allCartProductInCart) {
			totalCost += (cartProduct.getProduct().getPrice() * cartProduct.getTotalQuantity());
		}
	    
	    OrderSummary orderSummary = new OrderSummary(business, new Date(), totalCost, OrderStatus.PLACED, address);
	    
	    orderSummaryRepository.save(orderSummary);
	    
	    cartProdcutService.addCartDetailsInPurchaseDetail(orderSummaryDetail, orderSummary);
		
		return orderSummary.getId();
	}
	
	public void cancelOrder(Integer orderId) {
		OrderSummary orderSummary = orderSummaryRepository.getById(orderId);
		orderSummary.setOrderStatus(OrderStatus.CANCELLED);
		
		OrderSummary save = orderSummaryRepository.save(orderSummary);
	}
	
	public OrderSummary getOrderSummary(Integer orderId) {
		return orderSummaryRepository.getById(orderId);
	}
	
	public List<PurchaseDetail> getPurchaseDetailByOrderId(Integer orderId) {
		List<PurchaseDetail> purchaseDetailByOrderId = purchaseDetailRepository.findByOrderSummaryId(orderId);
		return purchaseDetailByOrderId;
	}
}
