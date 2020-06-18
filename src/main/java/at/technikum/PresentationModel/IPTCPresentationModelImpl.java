package at.technikum.PresentationModel;

import at.technikum.interfaces.models.IPTCModel;
import at.technikum.interfaces.presentationmodels.IPTCPresentationModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Collection;

public class IPTCPresentationModelImpl implements IPTCPresentationModel {

    private StringProperty keywords = new SimpleStringProperty();
    private StringProperty copyright = new SimpleStringProperty();
    private StringProperty headline = new SimpleStringProperty();

    StringProperty currentPhotographer = new SimpleStringProperty();
    String photographer;

    public IPTCPresentationModelImpl(IPTCModel iptcModel) {
        refresh(iptcModel);
    }

    @Override
    public void refresh(IPTCModel iptc) {
        keywords.setValue(iptc.getKeywords());
        copyright.setValue(iptc.getCopyrightNotice());
        headline.setValue(iptc.getHeadline());
    }

    @Override
    public void saveChanges(IPTCModel iptcModel) {
        iptcModel.setKeywords(keywords.getValue());
        iptcModel.setHeadline(headline.getValue());
        iptcModel.setCopyrightNotice(copyright.getValue());
    }

    public StringProperty keywordsProperty() {
        return this.keywords;
    }

    @Override
    public String getKeywords() {
        return this.keywords.get() != null ? this.keywords.get() : "";
    }

    @Override
    public void setKeywords(String value) {
        this.keywords.set(value);
    }

    public StringProperty copyrightProperty() {
        return this.copyright;
    }

    @Override
    public String getCopyrightNotice() {
        return this.copyright.get() != null ? this.copyright.get() : "";
    }

    @Override
    public void setCopyrightNotice(String value) {
        this.copyright.set(value);
    }

    @Override
    public Collection<String> getCopyrightNotices() {
        return null;
    }

    public StringProperty headlineProperty() {
        return this.headline;
    }

    @Override
    public String getHeadline() {
        return this.headline.get() != null ? this.headline.get() : "";
    }

    @Override
    public void setHeadline(String value) {
        this.headline.set(value);
    }

    @Override
    public String getByLine() {
        return null;
    }

    @Override
    public void setByLine(String value) {

    }

    @Override
    public String getcurrentPhotographer() {
        return this.currentPhotographer.get() != null ? this.currentPhotographer.get() : "";
    }

    @Override
    public void setcurrentPhotographer(String value) {
        this.currentPhotographer.setValue(value);
    }

    StringProperty currentPhotographerProperty() {
        return currentPhotographer;
    }
}
