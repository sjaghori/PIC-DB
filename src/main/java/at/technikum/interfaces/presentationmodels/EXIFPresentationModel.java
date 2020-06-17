package at.technikum.interfaces.presentationmodels;

public interface EXIFPresentationModel {
	/**
	 * Name of camera
	 */
	String getMake();

	/**
	 * Aperture number
	 */
	double getFNumber();

	/**
	 * Exposure time
	 */
	double getExposureTime();

	/**
	 * ISO value
	 */
	double getISOValue();

	/**
	 * Flash yes/no
	 */
	boolean getFlash();

	/**
	 * The Exposure Program as string
	 */
	String getExposureProgram();

	/**
	 * The Exposure Program as image resource
	 */
	String getExposureProgramResource();
}
