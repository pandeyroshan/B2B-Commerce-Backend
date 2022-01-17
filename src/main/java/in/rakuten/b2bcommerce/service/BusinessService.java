package in.rakuten.b2bcommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rakuten.b2bcommerce.dto.BusinessUpdateDetail;
import in.rakuten.b2bcommerce.enums.BusinessStatus;
import in.rakuten.b2bcommerce.model.Business;
import in.rakuten.b2bcommerce.repository.BusinessRepository;

@Service
public class BusinessService {
	@Autowired
	BusinessRepository businessRepository;
	
	public int saveOrUpdate(Business business) {
		businessRepository.save(business);
		return business.getId();
	}
	
	public List<Business> getAllBusiness() {
		List<Business> allBusiness = new ArrayList<Business>();
		businessRepository.findAll().forEach(business -> allBusiness.add(business));
		return allBusiness;
	}
	
	public Business getBusinessById(int businessId) {
		Business business = businessRepository.getById(businessId);
		return business;
	}
	
	public void deleteBusinessById(int businessId) {
		businessRepository.deleteById(businessId);
	}
	
	public void updateBusiness(Business business, int businessId) {
		businessRepository.save(business);
	}
	
	public void updateBusinessName(BusinessUpdateDetail businessUpdateDetail) {
		Business business = businessRepository.getById(businessUpdateDetail.getBusinessId());
		business.setBusinessName(businessUpdateDetail.getBusinessName());
		
		businessRepository.save(business);
	}
	
	public void approveBusiness(int businessId) {
		Business business = businessRepository.getById(businessId);
		business.setApproved(true);
		business.setStatus(BusinessStatus.APPROVED);
		
		Random random = new Random();
		int randomNumber = random.nextInt(900)+100;
		
		String customerId = Integer.toString(randomNumber)+Integer.toString(businessId);
		business.setCustomerId(customerId);
		
		businessRepository.save(business);
	}
	
	public void rejectBusiness(int businessId) {
		Business business = businessRepository.getById(businessId);
		business.setStatus(BusinessStatus.REJECTED);
		
		businessRepository.save(business);
	}
}
