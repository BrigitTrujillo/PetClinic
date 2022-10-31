package com.tecsup.petclinic.services;

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

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;


public class OwnerEliminacionTest {
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);
	
	@Autowired
	private OwnerService OwnerService;
	
	@Test
	public void testDeleteOwner() {

		long ID = 1;
		String FIRST_NAME = "Maria";
		
		Owner owner = new Owner(FIRST_NAME,ID);
		owner = OwnerEliminacionTest.create(owner);
		logger.info("" + owner);
		
		
		try {
			owner.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
			
		try {
			owner.findById(owner.getId());
			fail("Owner id = " + owner.getId() + " has not delete");
		} catch (OwnerNotFoundException e) {
		} 				


	}
	
	
	
}
