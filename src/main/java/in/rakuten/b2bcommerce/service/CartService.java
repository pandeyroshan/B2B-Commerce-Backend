package in.rakuten.b2bcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rakuten.b2bcommerce.dto.cartProductDetail;
import in.rakuten.b2bcommerce.model.Cart;
import in.rakuten.b2bcommerce.model.CartProduct;
import in.rakuten.b2bcommerce.model.Product;
import in.rakuten.b2bcommerce.repository.CartProductRepository;
import in.rakuten.b2bcommerce.repository.CartRepository;
import in.rakuten.b2bcommerce.repository.ProductRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CartProductRepository cartProductRepository;
	
	public Integer createCart(Cart cart) {
		cartRepository.save(cart);
		return cart.getId();
	}
	
	public void addToCart(cartProductDetail cartProductDetail) {
		Cart cart = cartRepository.getById(cartProductDetail.getCartId());
		Product product = productRepository.getById(cartProductDetail.getProductId());
		
		CartProduct cartProduct = new CartProduct(cart, product, 1);
		cartProductRepository.save(cartProduct);
	}
	
	public void removeFromCart(cartProductDetail cartProductDetail) {
		Cart cart = cartRepository.getById(cartProductDetail.getCartId());
		
		CartProduct cartProductByCartIdAndProductId = cartProductRepository.getCartProductByCartIdAndProductId(cartProductDetail.getCartId(), cartProductDetail.getProductId());
		
		cartProductRepository.deleteById(cartProductByCartIdAndProductId.getId());
		
		cartRepository.save(cart);
	}
}
