package at.technikum.interfaces.presentationmodels;

import at.technikum.interfaces.models.PhotographerModel;

import java.time.LocalDate;

public interface PhotographerPresentationModel {

	void refresh(PhotographerModel photographerModel);

	void update();

	public PhotographerModel getPhotographerModel();

	/**
	 * Database primary key
	 */
	int getID();

	/**
	 * Firstname, including middle name
	 */
	String getFirstName();

	void setFirstName(String value);

	/**
	 * Lastname
	 */
	String getLastName();

	void setLastName(String value);

	/**
	 * Birthday
	 */
	LocalDate getBirthDay();

	void setBirthDay(LocalDate value);

	/**
	 * Notes
	 */
	String getNotes();

	void setNotes(String value);

	/**
	 * Returns true, if the model is valid
	 */
	boolean isValid();

	/**
	 * returns true if the last name is valid
	 */
	boolean isValidLastName();

	/**
	 * returns true if the birthday is valid
	 */
	boolean isValidBirthDay();

}
