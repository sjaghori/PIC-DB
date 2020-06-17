package at.technikum.interfaces.presentationmodels;

import java.util.Collection;

import at.technikum.interfaces.presentationmodels.PicturePresentationModel;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

public interface PictureListPresentationModel {
	/**
	 * ViewModel of the current picture
	 */
	PicturePresentationModel getCurrentPicture();

	/**
	 * List of all PictureViewModels
	 */
	Collection<PicturePresentationModel> getList();

	/**
	 * All prev. pictures to the current selected picture.
	 */
	Collection<PicturePresentationModel> getPrevPictures();

	/**
	 * All next pictures to the current selected picture.
	 */
	Collection<PicturePresentationModel> getNextPictures();

	/**
	 * Number of all images
	 */
	int getCount();

	/**
	 * The current Index, 1 based
	 */
	int getCurrentIndex();

	/**
	 * {CurrentIndex} of {Cout}
	 */
	String getCurrentPictureAsString();

	ObservableList<ImageView> getpics();
}
