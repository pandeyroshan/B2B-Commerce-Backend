package in.rakuten.b2bcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.UserDetail;
import in.rakuten.b2bcommerce.service.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
@ApiOperation(value = "/api/v1/user", tags = "User Controller")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register-user")
	public int registerBusiness(@RequestBody UserDetail userDetail) {
//		User user = new User(userDetail.getUsername(), userDetail.getPassword(), userDetail.getEmail(), false);
//		
//		Business business = new Business(userDetail.getBusinessRegistrationNumber(), false, "PENDING");
//		Cart cart = new Cart();
//		
//		user.setBusiness(business);
//		user.setCart(cart);
//		
//		userService.saveOrUpdate(user);
		
//		return user.getId();
		return 0;
	}

}
