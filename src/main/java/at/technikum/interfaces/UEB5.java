package at.technikum.interfaces;

import at.technikum.interfaces.models.CameraModel;
import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.presentationmodels.CameraPresentationModel;
import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;

public interface UEB5 {
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
	 * Returns a empty PhotographerModel
	 * 
	 * @return
	 */
	PhotographerModel getEmptyPhotographerModel();

	
	/**
	 * Returns a Photographer Presenation Model from the given Model.
	 * @param mdl
	 * @return
	 */
	PhotographerPresentationModel getPhotographerPresentationModel(PhotographerModel mdl);

	/**
	 * Returns a empty CameraModel
	 *
	 * @return
	 */
	CameraModel getEmptyCameraModel();


	/**
	 * Returns a Camera Presenation Model from the given Model.
	 * @param mdl
	 * @return
	 */
	CameraPresentationModel getCameraPresentationModel(CameraModel mdl);

}
