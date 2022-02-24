package in.rakuten.b2bcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private Double price;

	private Integer inStockQuantity;

	private String imageLink;

	private Boolean active;

	public Product(Integer id, String name, Double price, Integer inStockQuantity, String imageLink, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.inStockQuantity = inStockQuantity;
		this.imageLink = imageLink;
		this.active = active;
	}

	public Product() {
		super();
	}

}
