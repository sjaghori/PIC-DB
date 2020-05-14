package at.technikum.interfaces;

import at.technikum.interfaces.presentationmodels.SearchPresentationModel;

public interface UEB3 {
	/**
	 * This method is only called to prove the unit test setup.
	 */
	void helloWorld();

	/**
	 * This method is called before any test is run. Use it to prepare your
	 * application for unit-testing.
	 * 
	 * @param picturePath
	 */
	void testSetup(String picturePath);

	/**
	 * Returns a business layer instance
	 * 
	 * @return
	 */
	BusinessLayer getBusinessLayer();
	
	/**
	 * Returns a mock data access layer 
	 * @return
	 */
	DataAccessLayer getDataAccessLayer();

	/**
	 * Returns a SearchPresentationModel
	 * @return
	 */
	SearchPresentationModel getSearchPresentationModel();
}
