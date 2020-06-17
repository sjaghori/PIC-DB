package at.technikum.interfaces;

import java.util.Collection;

import at.technikum.interfaces.models.*;

public interface DataAccessLayer {
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
	Collection<PictureModel> getPictures(String namePart,
			PhotographerModel photographerParts, IPTCModel iptcParts,
			EXIFModel exifParts) throws Exception;

	/**
	 * Returns ONE Picture from the database.
	 * 
	 * @param ID
	 * @return
	 */
	PictureModel getPicture(int ID);

	/**
	 * Saves all changes to the database.
	 * 
	 * @param picture
	 */
	void save(PictureModel picture);

	/**
	 * Deletes a Picture from the database.
	 * 
	 * @param ID
	 */
	void deletePicture(int ID);

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

}
