package at.technikum.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import at.technikum.interfaces.models.*;

public interface BusinessLayer {
	/**
	 * Returns a list of ALL Pictures from the directory, based on a database
	 * query.
	 * 
	 * @return
	 */
	Collection<PictureModel> getPictures();

	/**
	 * Returns a filterd list of Pictures from the directory, based on a
	 * database query.
	 * 
	 * @return
	 */
	List<PictureModel> getPictures(String searchText);

	/**
	 * Returns ONE Picture from the database.
	 * 
	 * @param ID
	 * @return
	 */
	PictureModel getPicture(int ID);

	void changePhotographer(PictureModel pictureModel, PhotographerModel photographerModel);

	void updatePicture(PictureModel picture);


	/**
	 * Saves all changes to the database.
	 * 
	 * @param picture
	 */
	void save(PictureModel picture);

	/**
	 * Deletes a Picture from the database AND from the file system.
	 * 
	 * @param ID
	 */
	void deletePicture(int ID);

	/**
	 * Syncs the picture folder with the database.
	 */
	void sync();

	/**
	 * Returns a list of ALL Photographers.
	 * 
	 * @return
	 */
	Collection<PhotographerModel> getPhotographers();

	/**
	 * Returns ONE Photographer
	 * 
	 * @param ID
	 * @return
	 */
	PhotographerModel getPhotographer(int ID);

	/**
	 * Saves all changes.
	 * 
	 * @param photographer
	 */
	void save(PhotographerModel photographer);

	/**
	 * Deletes a Photographer. A Exception is thrown if a Photographer is still
	 * linked to a picture.
	 * 
	 * @param ID
	 */
	void deletePhotographer(int ID);

	/**
	 * Updates a Photographer.
	 *
	 *
	 * @param photographer
	 * @param index
	 */
	void updatePhotographer(PhotographerModel photographer, int index);


	/**
	 * Extracts IPTC information from a picture. NOTE: You may simulate the
	 * action.
	 * 
	 * @param filename
	 * @return
	 */
	IPTCModel extractIPTC(String filename);

	/**
	 * Extracts EXIF information from a picture. NOTE: You may simulate the
	 * action.
	 * 
	 * @param filename
	 * @return
	 */
	EXIFModel extractEXIF(String filename);

	/**
	 * Writes IPTC information back to a picture. NOTE: You may simulate the
	 * action.
	 * 
	 * @param filename
	 * @param iptc
	 */
	void writeIPTC(String filename, IPTCModel iptc);

	Set<String> getDistinctKeyword();

	int getKeywordsCount(String keyword);


}
