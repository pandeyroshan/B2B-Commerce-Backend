package in.rakuten.b2bcommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rakuten.b2bcommerce.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	List<Address> getAllAddressByBusinessId(Integer businessId);
}
