package at.technikum.interfaces.models;

public interface IPTCModel {
	/**
	 * A list of keywords
	 */
	String getKeywords();
	void setKeywords(String value);

	/**
	 * copyright notices.
	 */
	String getCopyrightNotice();
	void setCopyrightNotice(String value);

	/**
	 * Summary/Headline of the picture
	 */
	String getHeadline();
	void setHeadline(String value);

}
