package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;


@Service
public class OwnerServiceImpl implements OwnerService {
	
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);

	@Autowired
	OwnerRepository ownerRepository;

	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}
	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	@Override
	public void delete(Long id) throws PetNotFoundException{
		Owner owner = findById(id);
		ownerRepository.delete(owner);
		
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Owner findById(long id) throws PetNotFoundException {
		Optional<Owner> owner = ownerRepository.findById(id);

		if ( !owner.isPresent())
			throw new PetNotFoundException("Record not found...!");
			
		return owner.get();
	}
	/**
	 * 
	 * @param first_name
	 * @return
	 */
	@Override
	public List<Owner> findByfirst_name(String first_name) {

		List<Owner> owners = ownerRepository.findByfirst_name(first_name);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	/**
	 * 
	 * @param last_name
	 * @return
	 */

	public List<Owner> findBylast_name(String last_name) {
		List<Owner> owners = ownerRepository.findByfirst_name(last_name);
	    owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	/**
	 * 
	 * @param address
	 * @return
	 */
	

	@Override
	public List<Owner>findByaddress(String address) {
		List<Owner> owners = ownerRepository.findByaddress(address);
	    owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	
	}
	/**
	 * 
	 * @param city
	 * @return
	 */
	

	@Override
	public List<Owner>findBycity(String city) {
		List<Owner> owners = ownerRepository.findBycity(city);
	    owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	/**
	 * 
	 * @param telephone
	 * @return
	 */
	public List<Owner>findBytelephone(String telephone) {
		List<Owner> owners = ownerRepository.findBytelephone(telephone);
	    owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	/**
	 * 
	 * @return
	 */

	@Override
	public Iterable<Owner> findAll() {
		
		// TODO Auto-generated 
		return ownerRepository.findAll();
	}
	@Override
	public List<Owner> findByTypelast_name(String last_name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Owner> findtelephone(String telephone) {
		// TODO Auto-generated method stub
		return null;
	}



}
