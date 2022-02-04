package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.AddressDetail;
import in.rakuten.b2bcommerce.model.Address;
import in.rakuten.b2bcommerce.service.AddressService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/save-address")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public Integer saveAddressForBusinessId(@RequestBody AddressDetail addressDetail) {
		Address address = addressService.createAddress(addressDetail);
		return address.getId();
	}

	@GetMapping("/get-all-address/{business_id}")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public List<Address> getAllAddressByBusinessId(@PathVariable("business_id") Integer businessId) {
		List<Address> allAddressByBusinessId = addressService.getAllAddressByBusinessId(businessId);
		return allAddressByBusinessId;
	}

	@DeleteMapping("/delete-address/{address_id}")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public void deleteAddress(@PathVariable("address_id") Integer addressId) {
		addressService.deleteAddressById(addressId);
	}
}
