package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.ProductQuantityInCart;
import in.rakuten.b2bcommerce.dto.cartProductDetail;
import in.rakuten.b2bcommerce.model.CartProduct;
import in.rakuten.b2bcommerce.service.CartProductService;
import in.rakuten.b2bcommerce.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	CartProductService cartProductService;
	
	@PostMapping("/add-to-cart")
	private void addToCart(@RequestBody cartProductDetail cartProductDetail) {
		cartService.addToCart(cartProductDetail);
	}
	
	@PostMapping("/remove-from-cart")
	private void removeFromCart(@RequestBody cartProductDetail cartProductDetail) {
		cartService.removeFromCart(cartProductDetail);
	}
	
	@PostMapping("/manage-quantity")
	private void increaseProductQuantityInCart(@RequestBody ProductQuantityInCart productQuantityInCart) {
		cartProductService.increaseProductQuantityInCart(productQuantityInCart);
	}
	
	@PostMapping("/cart-details/{user_id}")
	private List<CartProduct> getCartDetails(@PathVariable("user_id") Integer userId) {
		List<CartProduct> cartProductByUserId = cartProductService.getCartProductByUserId(userId);
		return cartProductByUserId;
	}
}
