package in.rakuten.b2bcommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.PurchaseDetail;

@Repository
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, Integer>{
	@Query(value="select * from purchase_detail p where p.order_id =?1", nativeQuery=true)
	List<PurchaseDetail> findByOrderSummaryId(Integer orderId);
}
