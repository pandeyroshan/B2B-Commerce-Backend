package in.rakuten.b2bcommerce.dto;

import lombok.Data;

@Data
public class ItemCount {
	private Integer totalNumberOfItemsInCart;

	public ItemCount(Integer totalNumberOfItemsInCart) {
		super();
		this.totalNumberOfItemsInCart = totalNumberOfItemsInCart;
	}

	public ItemCount() {
		super();
	}
}
