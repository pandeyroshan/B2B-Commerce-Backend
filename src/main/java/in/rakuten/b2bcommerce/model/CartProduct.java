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
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private Integer totalQuantity;

	public CartProduct(Cart cart, Product product, Integer totalQuantity) {
		super();
		this.cart = cart;
		this.product = product;
		this.totalQuantity = totalQuantity;
	}

	public CartProduct() {
		super();
	}

}
