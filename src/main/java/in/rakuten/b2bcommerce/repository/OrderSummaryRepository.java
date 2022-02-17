package in.rakuten.b2bcommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.OrderSummary;

@Repository
public interface OrderSummaryRepository extends JpaRepository<OrderSummary, Integer> {
	@Query(value = "select * from order_summary o where o.ordered_by =?1", nativeQuery = true)
	List<OrderSummary> findAllOrderSummaryByOrderedBy(Integer businessId);

	@Query(value = "select sum(total_cost) from order_summary", nativeQuery = true)
	Integer getTotalSumOfOrders();
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update order_summary set order_status =?2 where id =?1", nativeQuery = true)
	void UpdateOrderStatus(Integer orderId, String orderStatus);
}
