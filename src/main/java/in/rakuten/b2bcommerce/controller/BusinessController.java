package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@ApiOperation(value = "/api/v1/business", tags = "Business Controller")
public class BusinessController {
	@Autowired
	BusinessService businessService;

	@PostMapping("/update-business")
	private void updateBusiness(@RequestBody BusinessUpdateDetail businessUpdateDetail) {
		businessService.updateBusinessName(businessUpdateDetail);
	}

	@GetMapping("/approve-business/{businessId}")
	private void approveBusiness(@PathVariable("businessId") int businessId) {
		businessService.approveBusiness(businessId);
	}

	@GetMapping("/reject-business/{businessId}")
	private void rejectBusiness(@PathVariable("businessId") int businessId) {
		businessService.rejectBusiness(businessId);
	}

	@GetMapping("/all-business")
	private List<Business> getAllBusiness() {
		return businessService.getAllBusiness();
	}
}
