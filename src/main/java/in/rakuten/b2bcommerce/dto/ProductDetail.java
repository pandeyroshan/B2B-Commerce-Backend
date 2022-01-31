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
	
}
