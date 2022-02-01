package in.rakuten.b2bcommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.CartProduct;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
	@Query(value = "select * from cart_product c where c.cart_id =?1 and c.product_id =?2", nativeQuery = true)
	CartProduct getCartProductByCartIdAndProductId(Integer cartId, Integer productId);

	
	@Modifying
	@Query(value = "update cart_product c set c.total_quantity =?3 where c.cart_id=?1 and product_id=?2", nativeQuery = true)
	Integer increaseProductQuantityInCart(Integer cartId, Integer productId, Integer incrementValue);
	
	@Query(value = "select * from cart_product c where c.cart_id =?1", nativeQuery = true)
	List<CartProduct> getAllCartProductInCart(Integer cartId);
	
	@Query(value = "select total_quantity from cart_product c where c.cart_id=?1 and product_id=?2", nativeQuery=true)
	Integer getProductQuantityOfProductInCart(Integer cartId, Integer productId);
	
	@Query(value = "select count(*) from cart_product c where c.cart_id=?1", nativeQuery = true)
	Integer getTotalNumberOfItemsInCart(Integer cartId);
}
