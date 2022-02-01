package in.rakuten.b2bcommerce.dto;

import lombok.Data;

@Data
public class ProductDetail {
	private Integer id;
	private String name;
	private Double price;
	private Integer inStockQuantity;
	private String imageLink;
	private Boolean active;
	private Boolean isAddedToCart;

	public ProductDetail(Integer id, String name, Double price, Integer inStockQuantity, String imageLink,
			Boolean active, Boolean isAddedToCart) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.inStockQuantity = inStockQuantity;
		this.imageLink = imageLink;
		this.active = active;
		this.isAddedToCart = isAddedToCart;
	}

	public ProductDetail() {
		super();
	}

}
