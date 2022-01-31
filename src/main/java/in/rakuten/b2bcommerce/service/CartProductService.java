package in.rakuten.b2bcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.rakuten.b2bcommerce.dto.OrderSummaryDetail;
import in.rakuten.b2bcommerce.dto.ProductQuantityInCart;
import in.rakuten.b2bcommerce.model.Cart;
import in.rakuten.b2bcommerce.model.CartProduct;
import in.rakuten.b2bcommerce.model.OrderSummary;
import in.rakuten.b2bcommerce.model.PurchaseDetail;
import in.rakuten.b2bcommerce.repository.CartProductRepository;
import in.rakuten.b2bcommerce.repository.CartRepository;
import in.rakuten.b2bcommerce.repository.PurchaseDetailRepository;

@Service
public class CartProductService {
	
	@Autowired
	CartProductRepository cartProductRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	PurchaseDetailRepository purchaseDetailRepository;
	
	public int saveOrUpdate(CartProduct cartProduct) {
		cartProductRepository.save(cartProduct);
		return cartProduct.getId();
	}
	
	public CartProduct getCartProductById(int id) {
		return cartProductRepository.getById(id);
	}
	
	public void deleteCartProductById(int id) {
		cartProductRepository.deleteById(id);
	}
	
	@Transactional
	public void increaseProductQuantityInCart(ProductQuantityInCart productQuantityInCart) {
		Integer productQuantityOfProductInCart = cartProductRepository.getProductQuantityOfProductInCart(productQuantityInCart.getCartId(), productQuantityInCart.getProductId());
		cartProductRepository.increaseProductQuantityInCart(productQuantityInCart.getCartId(), productQuantityInCart.getProductId(), productQuantityOfProductInCart + productQuantityInCart.getIncrementValue());
	}
	
	public List<CartProduct> getCartProductByUserId(int userId) {
		Integer cartId = cartRepository.getCartIdForUser(userId);
		List<CartProduct> allCartProductInCart = cartProductRepository.getAllCartProductInCart(cartId);
		
		return allCartProductInCart;
	}
	
	public void addCartDetailsInPurchaseDetail(OrderSummaryDetail orderSummaryDetail, OrderSummary orderSummary) {
		Cart cart = cartRepository.getById(orderSummaryDetail.getCartId());
		List<CartProduct> allCartProductInCart = cartProductRepository.getAllCartProductInCart(cart.getId());
		
		for(CartProduct cartProduct: allCartProductInCart) {
			PurchaseDetail purchaseDetail = new PurchaseDetail(orderSummary, cartProduct.getProduct(), cartProduct.getTotalQuantity(), cartProduct.getTotalQuantity()*cartProduct.getProduct().getPrice()*1.0);
			purchaseDetailRepository.save(purchaseDetail);
		}
	}
}
