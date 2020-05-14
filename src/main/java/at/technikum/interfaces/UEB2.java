package at.technikum.interfaces;

import at.technikum.interfaces.models.CameraModel;
import at.technikum.interfaces.models.PictureModel;
import at.technikum.interfaces.presentationmodels.CameraPresentationModel;
import at.technikum.interfaces.presentationmodels.MainWindowPresentationModel;
import at.technikum.interfaces.presentationmodels.PicturePresentationModel;

public interface UEB2 {
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
	 * Returns a picture model.
	 * 
	 * @param filename
	 * @return
	 */
	PictureModel getPictureModel(String filename);

	/**
	 * Returns a picture PresentationModel.
	 * 
	 * @param mdl
	 * @return
	 */
	PicturePresentationModel getPicturePresentationModel(PictureModel mdl);
	
    /**
     * Returns the MainWindowPresentationModel
     * @return
     */
    MainWindowPresentationModel GetMainWindowPresentationModel();

	/**
	 * Returns a camera model.
	 * 
	 * @param producer
	 * @param make
	 * @return
	 */
	CameraModel getCameraModel(String producer, String make);

    /**
     * Returns a CameraPresentationModel
     * @return
     */
	CameraPresentationModel getCameraPresentationModel(CameraModel mdl);

}
