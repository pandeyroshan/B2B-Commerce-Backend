package in.rakuten.b2bcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query(value="select count(*) from product", nativeQuery = true)
	Integer getTotalProductsCount();

	@Modifying(clearAutomatically = true)
	@Query(value = "update product set active =?2 where id =?1", nativeQuery = true)
	void changeProductVisibility(Integer productId, Boolean status);
}
