package at.technikum.interfaces.presentationmodels;

import at.technikum.interfaces.presentationmodels.PictureListPresentationModel;
import at.technikum.interfaces.presentationmodels.PicturePresentationModel;
import at.technikum.interfaces.presentationmodels.SearchPresentationModel;

public interface MainWindowPresentationModel {
	/**
	 * The current picture ViewModel
	 */
	PicturePresentationModel getCurrentPicture();

	/**
	 * ViewModel with a list of all Pictures
	 */
	PictureListPresentationModel getList();

	/**
	 * Search ViewModel
	 */
	SearchPresentationModel getSearch();

	void selectPicture(int selectedIndex);

}
