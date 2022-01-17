package in.rakuten.b2bcommerce.dto;

import lombok.Data;

@Data
public class AddressDetail {
	private Integer businessId;
	private String contactPerson;
	private String ContactPersonPhoneNumber;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String pincode;
	private String city;
	private String country;
}
