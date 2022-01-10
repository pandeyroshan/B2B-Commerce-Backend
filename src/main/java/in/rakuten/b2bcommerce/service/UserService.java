package in.rakuten.b2bcommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rakuten.b2bcommerce.model.User;
import in.rakuten.b2bcommerce.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}
}