package in.rakuten.b2bcommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rakuten.b2bcommerce.dto.AdminTilesInfo;
import in.rakuten.b2bcommerce.repository.BusinessRepository;
import in.rakuten.b2bcommerce.repository.OrderSummaryRepository;
import in.rakuten.b2bcommerce.repository.ProductRepository;

@Service
public class AdminService {
	@Autowired
	private OrderSummaryRepository orderSummaryRepository;
	
	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public AdminTilesInfo getAdminTileInformation() {
		Integer totalSumOfOrders = orderSummaryRepository.getTotalSumOfOrders();
		Integer totalBusinesses = businessRepository.getTotalBusinesses();
		Integer totalApprovedBusiness = businessRepository.getTotalApprovedBusiness();
		Integer totalProductsCount = productRepository.getTotalProductsCount();
		
		return new AdminTilesInfo(totalSumOfOrders, totalBusinesses, totalApprovedBusiness, totalProductsCount);
	}
}
