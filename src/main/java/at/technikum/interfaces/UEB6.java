package at.technikum.interfaces;

import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.models.PictureModel;

public interface UEB6 {
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
	 * Returns a empty picture model
	 * 
	 * @return
	 */
	PictureModel getEmptyPictureModel();

	
	/**
	 * Returns a empty photographer model
	 * 
	 * @return
	 */
	PhotographerModel getEmptyPhotographerModel();

}
