package in.rakuten.b2bcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;

	private String email;

	private String password;

	private Boolean admin;

	public User(String username, String email, String password, Boolean admin) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public User() {
		super();
	}

}
