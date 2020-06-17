package at.technikum.interfaces.presentationmodels;

import at.technikum.interfaces.models.PictureModel;
import at.technikum.interfaces.presentationmodels.EXIFPresentationModel;
import at.technikum.interfaces.presentationmodels.IPTCPresentationModel;
import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;

public interface PicturePresentationModel {
	/**
	 * Database primary key
	 */
	int getID();

	/**
	 * Name of the file
	 */
	String getFileName();

	/**
	 * Full file path, used to load the image
	 */
	String getFilePath();

	/**
	 * The line below the Picture. Format: {IPTC.Headline|FileName} (by
	 * {Photographer|IPTC.ByLine}).
	 */
	String getDisplayName();

	/**
	 * The IPTC ViewModel
	 */
	IPTCPresentationModel getIPTC();

	/**
	 * The EXIF ViewModel
	 */
	EXIFPresentationModel getEXIF();

	/**
	 * The Photographer ViewModel
	 */
	PhotographerPresentationModel getPhotographer();

	/**
	 * Refreshes the ViewModel
	 */
	void refresh(PictureModel pic);


	/**
	 * gets the current PictureModel
	 */
	PictureModel getUpdatedModel();

}
