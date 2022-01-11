package in.rakuten.b2bcommerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import in.rakuten.b2bcommerce.enums.OrderStatus;
import lombok.Data;

@Entity
@Data
public class OrderSummary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="ordered_by")
	private Business orderedBy;
	
	private Date timestamp;
	
	private Double totalCost;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
}
