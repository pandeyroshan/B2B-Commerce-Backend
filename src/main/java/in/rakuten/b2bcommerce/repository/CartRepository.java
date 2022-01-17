package in.rakuten.b2bcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	@Query(value="select id from cart c where c.user_id =?1", nativeQuery = true)
	Integer getCartIdForUser(Integer userId);
	
	Integer findByUserId(Integer userId);
}
