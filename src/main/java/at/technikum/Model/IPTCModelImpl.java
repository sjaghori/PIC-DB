package at.technikum.Model;

import at.technikum.interfaces.models.IPTCModel;

public class IPTCModelImpl implements IPTCModel {

    private String keywords;                // a list of keywords/tags
    private String copyrightNotice;         // copyright notices
    private String headline;                // Summary/Headline of the picture

    @Override
    public String getKeywords() {
        return this.keywords;
    }

    @Override
    public void setKeywords(String value) {
        this.keywords = value;
    }

    @Override
    public String getCopyrightNotice() {
        return this.copyrightNotice;
    }

    @Override
    public void setCopyrightNotice(String value) {
        this.copyrightNotice = value;
    }

    @Override
    public String getHeadline() {
        return this.headline;
    }

    @Override
    public void setHeadline(String value) {
        this.headline = value;
    }

}