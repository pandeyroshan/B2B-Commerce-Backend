package in.rakuten.b2bcommerce.dto;

import lombok.Data;

@Data
public class Role {
	String name;

	public Role(String name) {
		super();
		this.name = name;
	}

	public Role() {
		super();
	}

}
