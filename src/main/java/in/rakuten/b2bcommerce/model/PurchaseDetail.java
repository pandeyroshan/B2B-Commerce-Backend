package in.rakuten.b2bcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class PurchaseDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private OrderSummary orderSummary;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private Integer count;
	
	private Integer totalCost;
}
