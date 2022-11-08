package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.PetNotFoundException;

public interface OwnerService {
	
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create(Owner owner);
	/**
	 * 
	 * @param owner
	 * @return
	 */


	Owner update(Owner owner);
	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	
	void delete(Long id) throws PetNotFoundException;
	/**
	 * 
	 * @param id
	 * @return
	 */
	Owner findById(long id) throws PetNotFoundException;

	/**
	 * 
	 * @param first_name
	 * @return
	 */

	List<Owner> findByfirst_name(String first_name);
	/**
	 * 
	 * @param last_name
	 * @return
	 */

	List<Owner> findByTypelast_name(String last_name);

	/**
	 * 
	 * @param address
	 * @return
	 */
	List<Owner> findByaddress(String address);
	/**
	 * 
	 * @param city
	 * @return
	 */
	
	List<Owner> findBycity(String city);
	/**
	 * 
	 * @param telephone
	 * @return
	 */
	
	List<Owner> findtelephone(String telephone);

	/**
	 * 
	 * @return
	 */
	Iterable<Owner> findAll();
}
