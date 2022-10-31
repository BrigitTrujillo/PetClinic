package com.tecsup.petclinic.services;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;


@SpringBootTest
public class OwnerServiceTestcreate {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTestcreate.class);
	

	@Test
	public void testCreateOwner() {
		int id = 1;
		String first_name="Brigit";
		String last_name = "Trujillo";
		String city = "Lima";
		String address = "BrigitT";
		String telephone = "916799362";
		
		Owner owner = new Owner(id, first_name, last_name, city,address,telephone);
		Owner ownerCreatea = OwnerServiceTestcreate.create(owner);
		logger.info("Owner CREATED :" + ownerCreatea);
				
	}


	private static Owner create(Owner owner) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
