package at.technikum.interfaces.presentationmodels;

import java.util.Collection;

import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;

public interface PhotographerListPresentationModel {
	/**
	 * List of all PhotographerViewModel
	 */
	Collection<PhotographerPresentationModel> getList();

	/**
	 * The currently selected PhotographerViewModel
	 */
	PhotographerPresentationModel getCurrentPhotographer();

}
