package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public Business getMyBusiness(@PathVariable("businessId") int businessId) {
		return businessService.getBusinessById(businessId);
	}

	@PostMapping("/update-business")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public void updateBusiness(@RequestBody BusinessUpdateDetail businessUpdateDetail) {
		businessService.updateBusinessName(businessUpdateDetail);
	}

	@GetMapping("/approve-business/{businessId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void approveBusiness(@PathVariable("businessId") int businessId) {
		businessService.approveBusiness(businessId);
	}

	@GetMapping("/reject-business/{businessId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void rejectBusiness(@PathVariable("businessId") int businessId) {
		businessService.rejectBusiness(businessId);
	}

	@GetMapping("/all-business")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Business> getAllBusiness() {
		return businessService.getAllBusiness();
	}
}
