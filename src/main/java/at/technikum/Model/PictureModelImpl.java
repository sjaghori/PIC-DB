package at.technikum.Model;

import at.technikum.interfaces.models.EXIFModel;
import at.technikum.interfaces.models.IPTCModel;
import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.models.PictureModel;

public class PictureModelImpl implements PictureModel {

    private int id;
    private String filename;
    private IPTCModel iptcModel;
    private EXIFModel exifModel;
    private String path;
    private PhotographerModel photographer;

    public PictureModelImpl(int id, String filename, String path) {
        this.id = id;
        this.filename = filename;
        this.path = path;
        photographer = new PhotographerModelImpl();
        iptcModel = new IPTCModelImpl();
        exifModel = new EXIFModelImpl();
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void setID(int value) {
        this.id = value;
    }

    @Override
    public String getFileName() {
        return this.filename;
    }

    @Override
    public void setFileName(String value) {
        this.filename = value;
    }

    @Override
    public IPTCModel getIPTC() {
        return this.iptcModel;
    }

    @Override
    public void setIPTC(IPTCModel value) {
        if (this.iptcModel != null) {
            this.iptcModel = value;
        }
    }

    @Override
    public EXIFModel getEXIF() {
        return this.exifModel;
    }

    @Override
    public void setEXIF(EXIFModel value) {
        if (this.exifModel != null) {
            this.exifModel = value;
        }
    }

    @Override
    public PhotographerModel getPhotographer() {
        return this.photographer;
    }

    @Override
    public void setPhotographer(PhotographerModel photographer) {
        if (photographer != null)
            this.photographer = photographer;
    }
}
