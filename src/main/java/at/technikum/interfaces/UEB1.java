package at.technikum.interfaces;

import at.technikum.interfaces.models.*;
import at.technikum.interfaces.presentationmodels.*;

public interface UEB1 {

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
	 * Returns a data access layer instance. It does not matter if it's a real
	 * one or the MockDAL for unit-tests.
	 * 
	 * @return
	 */
	DataAccessLayer getAnyDataAccessLayer();

	/**
	 * Returns a instance of the JavaFX application class.
	 * 
	 * @return
	 */
	Application getApplication();

	/**
	 * Returns a empty model.
	 * 
	 * @return
	 */
	PictureModel getEmptyPictureModel();

	/**
	 * Returns a empty model.
	 * 
	 * @return
	 */
	PhotographerModel getEmptyPhotographerModel();
	/**
	 * Returns a empty model.
	 * 
	 * @return
	 */
	CameraModel getEmptyCameraModel();

	/**
	 * Returns a empty model.
	 * 
	 * @return
	 */
	IPTCModel getEmptyIPTCModel();

	/**
	 * Returns a empty model.
	 * 
	 * @return
	 */
	EXIFModel getEmptyEXIFModel();

	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	MainWindowPresentationModel getEmptyMainWindowPresentationModel();

	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	SearchPresentationModel getEmptySearchPresentationModel();

	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	PictureListPresentationModel getEmptyPictureListPresentationModel();

	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	PicturePresentationModel getEmptyPicturePresentationModel();

	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	IPTCPresentationModel getEmptyIPTCPresentationModel();

	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	EXIFPresentationModel getEmptyEXIFPresentationModel();

	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	PhotographerListPresentationModel getEmptyPhotographerListPresentationModel();

	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	PhotographerPresentationModel getEmptyPhotographerPresentationModel();
	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	CameraListPresentationModel getEmptyCameraListPresentationModel();

	/**
	 * Returns a empty PresentationModel
	 * 
	 * @return
	 */
	CameraPresentationModel getEmptyCameraPresentationModel();
}
