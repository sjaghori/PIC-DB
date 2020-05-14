package at.technikum.interfaces;

import at.technikum.interfaces.models.CameraModel;
import at.technikum.interfaces.models.EXIFModel;
import at.technikum.interfaces.models.IPTCModel;
import at.technikum.interfaces.presentationmodels.CameraPresentationModel;
import at.technikum.interfaces.presentationmodels.EXIFPresentationModel;
import at.technikum.interfaces.presentationmodels.IPTCPresentationModel;

public interface UEB4 {
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
     * Returns a empty EXIF model
     * 
     * @return
     */
    EXIFModel getEmptyEXIFModel();

    /**
     * Returns a EXIF PresentationModel representing the given model
     * 
     * @param mdl
     * @return
     */
    EXIFPresentationModel getEXIFPresentationModel(EXIFModel mdl);

    /**
     * Returns a empty IPTC model
     * 
     * @return
     */
    IPTCModel getEmptyIPTCModel();

    /**
     * Returns a IPTC PresentationModel representing the given model
     * 
     * @param mdl
     * @return
     */
    IPTCPresentationModel getIPTCPresentationModel(IPTCModel mdl);

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
