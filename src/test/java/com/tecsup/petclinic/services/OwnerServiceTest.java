package com.tecsup.petclinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	//@Autowired
   //	private OwnerService ownerService;

	/**
	 * 
	 */
	/*
	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String NAME = "Jaime";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnertNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info("" + owner);

		assertEquals(NAME, owner.getName());

	}
	*/
}
