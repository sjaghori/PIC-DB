package at.technikum.Model;

import at.technikum.interfaces.models.IPTCModel;

public class IPTCModelImpl implements IPTCModel {

    private String keywords;
    private String byLine;
    private String copyrightNotice;
    private String headline;
    private String caption;

    @Override
    public String getKeywords() {
        return this.keywords;
    }

    @Override
    public void setKeywords(String value) {
        this.keywords = value;
    }

    @Override
    public String getByLine() {
        return this.byLine;
    }

    @Override
    public void setByLine(String value) {
        this.byLine = value;
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

    @Override
    public String getCaption() {
        return this.caption;
    }

    @Override
    public void setCaption(String value) {
        this.caption = value;
    }
}