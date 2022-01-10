package in.rakuten.b2bcommerce.dto;

import lombok.Data;

@Data
public class UserDetail {
	private String username;
	private String password;
	private String email;
	private Integer businessRegistrationNumber;
}