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
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="business_id")
	private Business business;
	
	private String contactPersonName;
	
	private String contactPersonPhoneNumber;
	
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	
	private String pincode;
	private String city;
	private String country;

	public Address(Business business, String contactPersonName, String contactPersonPhoneNumber, String addressLine1,
			String addressLine2, String addressLine3, String pincode, String city, String country) {
		super();
		this.business = business;
		this.contactPersonName = contactPersonName;
		this.contactPersonPhoneNumber = contactPersonPhoneNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.pincode = pincode;
		this.city = city;
		this.country = country;
	}
	
	public Address() {
		super();
	}
}
