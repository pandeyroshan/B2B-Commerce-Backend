package in.rakuten.b2bcommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.rakuten.b2bcommerce.dto.BusinessDetail;
import in.rakuten.b2bcommerce.model.Business;
import in.rakuten.b2bcommerce.model.User;
import in.rakuten.b2bcommerce.repository.BusinessRepository;
import in.rakuten.b2bcommerce.repository.CartRepository;
import in.rakuten.b2bcommerce.repository.UserRepository;
import in.rakuten.b2bcommerce.utils.JwtTokenUtil;
import in.rakuten.b2bcommerce.dto.Role;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BusinessRepository businessRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}
	
	public Role getUserRoleFromJwtToken(String token) {
		String username = this.jwtTokenUtil.getUsernameFromToken(token);
		Boolean isAdmin = userRepository.checkIfAdminByUsername(username);
		
		if(Boolean.TRUE.equals(isAdmin)) {
			return new Role("ADMIN");
		} else {
			return new Role("BUSINESS");
		}
	}
	
	public BusinessDetail getBusinessDetailsFromJwtToken(String token) {
		String username = this.jwtTokenUtil.getUsernameFromToken(token);
		Integer userId = this.userRepository.getIdByUsername(username);
		Business business = this.businessRepository.findByUserId(userId);
		Integer cartIdForUser = cartRepository.getCartIdForUser(userId);
		
		return new BusinessDetail(business.getId(), userId, cartIdForUser);
	}
	
	
}