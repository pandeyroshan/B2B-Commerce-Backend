package in.rakuten.b2bcommerce.dto;

import lombok.Data;

@Data
public class BusinessDetail {
	private Integer businessId;
	private Integer userId;
	private Integer cartId;
	
	public BusinessDetail(Integer businessId, Integer userId, Integer cartId) {
		super();
		this.businessId = businessId;
		this.userId = userId;
		this.cartId = cartId;
	}

	public BusinessDetail() {
		super();
	}
}
