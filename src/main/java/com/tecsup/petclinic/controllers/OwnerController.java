package com.tecsup.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tecsup.petclinic.dto.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.services.OwnerService;

/**
 * 
 * @author jgomezm
 *
 */
@RestController
public class OwnerController {

	@Autowired
	private OwnerService service;
	 
	/**
	 * 
	 * @return
	 */
	// @JsonIgnore
	@GetMapping("/owners")
	public Iterable<Owner> getOwners() {
		//
		return service.findAll();
	}

	
	/**
	 * Create Owner
	 * 
	 * @param newOwner
	 * @return
	 */
	/*
	@PostMapping("/owners")
	@ResponseStatus(HttpStatus.CREATED)
	Pet create(@RequestBody Owner newOwner) {
		return service.create(newOwner);
	}*/
	
	/**
	 *  Create Owner
	 * @param newOwner
	 * @return
	 */
	@PostMapping("/pets")
	@ResponseStatus(HttpStatus.CREATED)
	Owner create(@RequestBody OwnerDTO newOwner) {
		Owner owner = new Owner();
		owner.setFirst_name(newOwner.getFirstname());
		owner.setLast_name(newOwner.getLastname());
		owner.setAddress(newOwner.getAddress());
		owner.setCity(newOwner.getCity());
		owner.setTelephone(newOwner.getTelephone());
		
		return service.create(owner);
	}
	
	
	
	/**
	 * Find by id
	 * 
	 * @param id
	 * @return
	 * @throws PetNotFoundException
	 */
	@GetMapping("/owners/{id}")
	ResponseEntity<Owner> findOne(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (OwnerNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Save or update
	 * 
	 * @param newPet
	 * @param id
	 * @return
	 */
	@PutMapping("/owners/{id}")
	Owner saveOrUpdate(@RequestBody OwnerDTO newOwner, @PathVariable Long id) {
		Owner owner = null;
		try {
			owner = service.findById(id);
			owner.setFirst_name(newOwner.getFirstname());
			owner.setLast_name(newOwner.getLastname());
			owner.setAddress(newOwner.getAddress());
			owner.setCity(newOwner.getCity());
			owner.setTelephone(newOwner.getTelephone());
			service.update(owner);
		} catch (OwnerNotFoundException e) {
			owner = service.create(owner);
		}
		return owner;
	}

	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/owners/{id}")
	ResponseEntity<String> delete(@PathVariable Long id) {

		try {
			service.delete(id);
			return new ResponseEntity<>("" + id, HttpStatus.OK);
		} catch (OwnerNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}