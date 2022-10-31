package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;

import com.tecsup.petclinic.entities.Pet;

public class OwnerServiceUpdate {
	public void testUpdatePet() {

		int Id=1;
		String first_name="John",
		String last_name="Baldeon",
		String city ="Lima";
		String address="johnb";
		String telephone="987654321"
		
		int Id=2;
		String first_name="John",
		String last_name="Baldeon",
		String city ="Lima";
		String address="johnb";
		String telephone="987654321"

		Owner owner = new Owner(Id,first_name,last_name,city,address,telephone);

		// Create record
		logger.info(">" + owner);
		Owner ownerCreated = ownerService.create(owner);
		logger.info(">>" + ownerCreated);

		create_id = ownerCreated.getId();

		// Prepare data for update
		ownerCreated.setFirst_name();
		ownerCreated.setLast_name();
		ownerCreated.setCity();
		ownerCreated.setAddress();
		ownerCreated.setTelephone();

		// Execute update
		Owner upgradeOwner = ownerService.update(OwnerCreated);
		logger.info(">>>>" + upgradeOwner);

		//        ACTUAL       EXPECTED
		assertThat(create_id ,notNullValue());
		assertThat(upgradeOwner.getId(), is(create_Id));
		assertThat(upgradeOwner.getFirst_name(), is(first_name));
		assertThat(upgradeOwner.getLast_name(), is(last_name));
		assertThat(upgradeOwner.getcity(), is(city));
		assertThat(upgradeOwner.getTelephone(), is(telephone));
	}
}
