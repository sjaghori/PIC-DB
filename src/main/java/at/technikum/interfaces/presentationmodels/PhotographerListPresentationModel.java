package at.technikum.interfaces.presentationmodels;

import java.util.Collection;

import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;

public interface PhotographerListPresentationModel {
	/**
	 * List of all PhotographerViewModel
	 */
	Collection<PhotographerModel> getList();

	/**
	 * The currently selected PhotographerViewModel
	 */
	PhotographerModel getCurrentPhotographer(int index);

	void updatePhotographer(int index, PhotographerModel photographerModel);

}
