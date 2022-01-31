package in.rakuten.b2bcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.UserDetail;
import in.rakuten.b2bcommerce.enums.BusinessStatus;
import in.rakuten.b2bcommerce.model.Business;
import in.rakuten.b2bcommerce.model.Cart;
import in.rakuten.b2bcommerce.model.User;
import in.rakuten.b2bcommerce.service.BusinessService;
import in.rakuten.b2bcommerce.service.CartService;
import in.rakuten.b2bcommerce.service.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@ApiOperation(value = "/api/v1/user", tags = "User Controller")
public class UserController {
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	UserService userService;
	
	@Autowired
	BusinessService businessService;
	
	@Autowired
	CartService cartService;

	@PostMapping("/register-user")
	public int registerBusiness(@RequestBody UserDetail userDetail) {
		User user = new User(userDetail.getUsername(), userDetail.getEmail(), bcryptEncoder.encode(userDetail.getPassword()), false);
		
		userService.saveOrUpdate(user);
		
		Business business = new Business(null, userDetail.getBusinessRegistrationNumber(), false, BusinessStatus.PENDING, user);
		businessService.saveOrUpdate(business);
		
		Cart cart = new Cart(user);
		cartService.createCart(cart);
		
		return user.getId();
	}

}
