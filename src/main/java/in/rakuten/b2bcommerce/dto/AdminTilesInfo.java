package in.rakuten.b2bcommerce.dto;

import lombok.Data;

@Data
public class AdminTilesInfo {
	private Integer totalSales;
	private Integer totalBusiness;
	private Integer totalApprovedBusiness;
	private Integer totalNumberOfProducts;

	public AdminTilesInfo(Integer totalSales, Integer totalBusiness, Integer totalApprovedBusiness,
			Integer totalNumberOfProducts) {
		super();
		this.totalSales = totalSales;
		this.totalBusiness = totalBusiness;
		this.totalApprovedBusiness = totalApprovedBusiness;
		this.totalNumberOfProducts = totalNumberOfProducts;
	}

}
