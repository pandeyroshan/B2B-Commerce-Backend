package in.rakuten.b2bcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.OrderSummary;

@Repository
public interface OrderSummaryRepository extends JpaRepository<OrderSummary, Integer>{

}
