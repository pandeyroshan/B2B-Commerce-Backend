package in.rakuten.b2bcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
	
	@Query(value="select admin from user u where u.username =?1", nativeQuery=true)
	Boolean checkIfAdminByUsername(String username);
	
	@Query(value="select id from user u where u.username =?1", nativeQuery = true)
	Integer getIdByUsername(String username);
}
