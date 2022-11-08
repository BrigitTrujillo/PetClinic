package com.tecsup.petclinic.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tecsup.petclinic.entities.Owner;
@Repository
public interface OwnerRepository 
   extends CrudRepository<Owner, Long>{
	
	List<Owner> findByfirst_name(String first_name);

	List<Owner> findBylast_name(String last_name);

	List<Owner> findByaddress(String address);
	
	List<Owner> findBycity(String city);
	
	List<Owner> findBytelephone(String telephone);
	
	
}
