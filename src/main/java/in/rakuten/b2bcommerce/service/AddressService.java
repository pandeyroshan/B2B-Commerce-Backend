package in.rakuten.b2bcommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rakuten.b2bcommerce.dto.AddressDetail;
import in.rakuten.b2bcommerce.model.Address;
import in.rakuten.b2bcommerce.model.Business;
import in.rakuten.b2bcommerce.repository.AddressRepository;
import in.rakuten.b2bcommerce.repository.BusinessRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	BusinessRepository businessRepository;

	public Address createAddress(AddressDetail addressDetail) {
		Business business = businessRepository.getById(addressDetail.getBusinessId());

		Address address = new Address(business, addressDetail.getContactPerson(),
				addressDetail.getContactPersonPhoneNumber(), addressDetail.getAddressLine1(),
				addressDetail.getAddressLine2(), addressDetail.getAddressLine3(), addressDetail.getPincode(),
				addressDetail.getCity(), addressDetail.getCountry());
		
		addressRepository.save(address);
		
		return address;
	}
	
	public List<Address> getAllAddressByBusinessId(Integer businessId){
		List<Address> allAddressByBusinessId = addressRepository.getAllAddressByBusinessId(businessId);
		
		return allAddressByBusinessId;
	}
	
	public void deleteAddressById(Integer addressId) {
		addressRepository.deleteById(addressId);
	}
}
