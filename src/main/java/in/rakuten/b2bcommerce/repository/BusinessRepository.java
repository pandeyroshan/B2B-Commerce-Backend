package in.rakuten.b2bcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer>{
	Business findByUserId(Integer userId);
}
