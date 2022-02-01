package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.BusinessUpdateDetail;
import in.rakuten.b2bcommerce.model.Business;
import in.rakuten.b2bcommerce.service.BusinessService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@ApiOperation(value = "/api/v1/business", tags = "Business Controller")
public class BusinessController {
	@Autowired
	BusinessService businessService;
	
	@GetMapping("/my-business/{businessId}")
	public Business getMyBusiness(@PathVariable("businessId") int businessId) {
		return businessService.getBusinessById(businessId);
	}

	@PostMapping("/update-business")
	public void updateBusiness(@RequestBody BusinessUpdateDetail businessUpdateDetail) {
		System.out.println("\n\n\nUPDATE CONTROLLER\n\n\n");
		businessService.updateBusinessName(businessUpdateDetail);
	}

	@GetMapping("/approve-business/{businessId}")
	public void approveBusiness(@PathVariable("businessId") int businessId) {
		businessService.approveBusiness(businessId);
	}

	@GetMapping("/reject-business/{businessId}")
	public void rejectBusiness(@PathVariable("businessId") int businessId) {
		businessService.rejectBusiness(businessId);
	}

	@GetMapping("/all-business")
	public List<Business> getAllBusiness() {
		return businessService.getAllBusiness();
	}
}
