package in.rakuten.b2bcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PurchaseDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderSummary orderSummary;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private Integer quantityOrdered;

	private Double totalCost;

	public PurchaseDetail(OrderSummary orderSummary, Product product, Integer quantityOrdered, double d) {
		super();
		this.orderSummary = orderSummary;
		this.product = product;
		this.quantityOrdered = quantityOrdered;
		this.totalCost = d;
	}

	public PurchaseDetail() {
		super();
	}
}
