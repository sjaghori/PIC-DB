package at.technikum.interfaces.presentationmodels;

import at.technikum.interfaces.models.PictureModel;

import java.util.List;

public interface SearchPresentationModel {
	/**
	 * The search text
	 */
	String getSearchText();

	List<PictureModel> getSearchedPictures();

	/**
	 * True, if a search is active
	 * TODO: Rename to isActive();
	 */
	boolean getIsActive();

	/**
	 * Number of photos found.
	 */
	int getResultCount();

}
