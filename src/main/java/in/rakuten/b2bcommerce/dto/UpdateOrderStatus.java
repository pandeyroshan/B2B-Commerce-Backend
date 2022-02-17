package in.rakuten.b2bcommerce.dto;

import lombok.Data;

@Data
public class UpdateOrderStatus {
	private Integer orderId;
	private String orderStatus;

	public UpdateOrderStatus(Integer orderId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}
}