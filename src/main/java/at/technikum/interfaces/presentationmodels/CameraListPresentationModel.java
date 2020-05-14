package at.technikum.interfaces.presentationmodels;

import java.util.Collection;

import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;

public interface CameraListPresentationModel {
	/**
	 * List of all CameraViewModel
	 */
	Collection<CameraPresentationModel> getList();

	/**
	 * The currently selected CameraViewModel
	 */
	CameraPresentationModel getCurrentCamera();

}
