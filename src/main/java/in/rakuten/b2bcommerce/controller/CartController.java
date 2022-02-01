package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.ItemCount;
import in.rakuten.b2bcommerce.dto.ProductQuantityInCart;
import in.rakuten.b2bcommerce.dto.cartProductDetail;
import in.rakuten.b2bcommerce.model.CartProduct;
import in.rakuten.b2bcommerce.service.CartProductService;
import in.rakuten.b2bcommerce.service.CartService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	CartProductService cartProductService;
	
	@PostMapping("/add-to-cart")
	public void addToCart(@RequestBody cartProductDetail cartProductDetail) {
		cartService.addToCart(cartProductDetail);
	}
	
	@PostMapping("/remove-from-cart")
	public void removeFromCart(@RequestBody cartProductDetail cartProductDetail) {
		cartService.removeFromCart(cartProductDetail);
	}
	
	@PostMapping("/manage-quantity")
	public void increaseProductQuantityInCart(@RequestBody ProductQuantityInCart productQuantityInCart) {
		cartProductService.increaseProductQuantityInCart(productQuantityInCart);
	}
	
	@GetMapping("/cart-details/{user_id}")
	public List<CartProduct> getCartDetails(@PathVariable("user_id") Integer userId) {
		return cartProductService.getCartProductByUserId(userId);
	}
	
	@GetMapping("/total-item-in-cart/{cart_id}")
	public ItemCount getTotalNumberOfItemsInCart(@PathVariable("cart_id") Integer cartId) {
		return cartProductService.getTotalNumberOfItemsInCart(cartId);
	}
}
