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

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;

@SpringBootTest
public class PetServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(PetServiceTest.class);

	@Autowired
	private PetService petService;

	/**
	 * 
	 */
	@Test
	public void testFindPetById() {

		long ID = 1;
		String NAME = "Leo";
		Pet pet = null;
		
		try {
			pet = petService.findById(ID);
		} catch (PetNotFoundException e) {
			fail(e.getMessage());
		}
		
		logger.info("" + pet);
		assertThat(pet.getName(), is(NAME));

	}

	/**
	 * 
	 */
	@Test
	public void testFindPetByName() {

		String FIND_NAME = "Leo";
		int SIZE_EXPECTED = 1;

		List<Pet> pets = petService.findByName(FIND_NAME);

		assertThat(pets.size(), is(SIZE_EXPECTED));
	}

	/**
	 * 
	 */
	@Test
	public void testFindPetByTypeId() {

		int TYPE_ID = 5;
		int SIZE_EXPECTED = 2;

		List<Pet> pets = petService.findByTypeId(TYPE_ID);

		assertThat(pets.size(), is(SIZE_EXPECTED));
	}

	/**
	 * 
	 */
	@Test
	public void testFindPetByOwnerId() {

		int OWNER_ID = 10;
		int SIZE_EXPECTED = 2;

		List<Pet> pets = petService.findByOwnerId(OWNER_ID);

		assertThat(pets.size(), is(SIZE_EXPECTED));
		
	}

	/**
	 *  To get ID generate , you need 
	 *  setup in id primary key in your
	 *  entity this annotation :
	 *  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Test
	public void testCreatePet() {

		String PET_NAME = "Ponky";
		int OWNER_ID = 1;
		int TYPE_ID = 1;

		Pet pet = new Pet(PET_NAME, 1, 1);
		
		Pet petCreated = petService.create(pet);
		
		logger.info("PET CREATED :" + petCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(petCreated.getId()      , notNullValue());
		assertThat(petCreated.getName()    , is(PET_NAME));
		assertThat(petCreated.getOwnerId() , is(OWNER_ID));
		assertThat(petCreated.getTypeId()  , is(TYPE_ID));

	}

	
	/**
	 * 
	 */
	@Test
	public void testUpdatePet() {

		String PET_NAME = "Bear";
		int OWNER_ID = 1;
		int TYPE_ID = 1;
		long create_id = -1;

		String UP_PET_NAME = "Bear2";
		int UP_OWNER_ID = 2;
		int UP_TYPE_ID = 2;

		Pet pet = new Pet(PET_NAME, OWNER_ID, TYPE_ID);

		// Create record
		logger.info(">" + pet);
		Pet petCreated = petService.create(pet);
		logger.info(">>" + petCreated);

		create_id = petCreated.getId();

		// Prepare data for update
		petCreated.setName(UP_PET_NAME);
		petCreated.setOwnerId(UP_OWNER_ID);
		petCreated.setTypeId(UP_TYPE_ID);

		// Execute update
		Pet upgradePet = petService.update(petCreated);
		logger.info(">>>>" + upgradePet);

		//        ACTUAL       EXPECTED
		assertThat(create_id ,notNullValue());
		assertThat(upgradePet.getId(), is(create_id));
		assertThat(upgradePet.getName(), is(UP_PET_NAME));
		assertThat(upgradePet.getTypeId(), is(UP_OWNER_ID));
		assertThat(upgradePet.getOwnerId(), is(UP_TYPE_ID));
	}

	/**
	 * 
	 */
	@Test
	public void testDeletePet() {

		String PET_NAME = "Bird";
		int OWNER_ID = 1;
		int TYPE_ID = 1;

		Pet pet = new Pet(PET_NAME, OWNER_ID, TYPE_ID);
		pet = petService.create(pet);
		logger.info("" + pet);

		try {
			petService.delete(pet.getId());
		} catch (PetNotFoundException e) {
			fail(e.getMessage());
		}
			
		try {
			petService.findById(pet.getId());
			fail("Pet id = " + pet.getId() + " has not delete");
		} catch (PetNotFoundException e) {
		} 				

	}
}
