package in.rakuten.b2bcommerce.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import in.rakuten.b2bcommerce.enums.BusinessStatus;
import lombok.Data;

@Entity
@Data
public class Business {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String businessName;
	
	private String registrationNumber;
	
	private boolean approved;
	
	@Enumerated(EnumType.STRING)
	private BusinessStatus status;
	
	@OneToOne
	@JoinColumn(name="owner_id")
	private User user;
}
