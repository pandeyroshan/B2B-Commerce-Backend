package in.rakuten.b2bcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	public Cart(User user) {
		super();
		this.user = user;
	}

	public Cart() {
		super();
	}
}
