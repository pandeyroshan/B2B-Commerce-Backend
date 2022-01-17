package in.rakuten.b2bcommerce.dto;

import lombok.Data;

@Data
public class ProductQuantityInCart {
	private int productId;
	private int cartId;
	private int incrementValue;
}
