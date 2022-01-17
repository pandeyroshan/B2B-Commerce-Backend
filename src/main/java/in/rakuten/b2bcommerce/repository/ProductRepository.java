package in.rakuten.b2bcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
