package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.repositories.PetRepository;

/**
 * 
 * @author jgomezm
 *
 */
@Service
public class PetServiceImpl implements PetService {

	private static final Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);

	@Autowired
	PetRepository petRepository;

	/**
	 * 
	 * @param pet
	 * @return
	 */
	@Override
	public Pet create(Pet pet) {
		return petRepository.save(pet);
	}

	/**
	 * 
	 * @param pet
	 * @return
	 */
	@Override
	public Pet update(Pet pet) {
		return petRepository.save(pet);
	}


	/**
	 * 
	 * @param id
	 * @throws PetNotFoundException
	 */
	@Override
	public void delete(Long id) throws PetNotFoundException{

		Pet pet = findById(id);
		petRepository.delete(pet);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Pet findById(long id) throws PetNotFoundException {

		Optional<Pet> pet = petRepository.findById(id);

		if ( !pet.isPresent())
			throw new PetNotFoundException("Record not found...!");
			
		return pet.get();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public List<Pet> findByName(String name) {

		List<Pet> pets = petRepository.findByName(name);

		pets.stream().forEach(pet -> logger.info("" + pet));

		return pets;
	}

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	@Override
	public List<Pet> findByTypeId(int typeId) {

		List<Pet> pets = petRepository.findByTypeId(typeId);

		pets.stream().forEach(pet -> logger.info("" + pet));

		return pets;
	}

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	@Override
	public List<Pet> findByOwnerId(int ownerId) {

		List<Pet> pets = petRepository.findByOwnerId(ownerId);

		pets.stream().forEach(pet -> logger.info("" + pet));

		return pets;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Iterable<Pet> findAll() {
		
		// TODO Auto-generated 
		return petRepository.findAll();
	
	}

}