package at.technikum.Model;

import at.technikum.interfaces.models.CameraModel;
import at.technikum.interfaces.models.EXIFModel;
import at.technikum.interfaces.models.IPTCModel;
import at.technikum.interfaces.models.PictureModel;

public class PictureModelImpl implements PictureModel {
    private int id;
    private String filename;
    private IPTCModel iptcModel;
    private EXIFModel exifModel;
    private CameraModel cameraModel;

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
        this.iptcModel = value;
    }

    @Override
    public EXIFModel getEXIF() {
        return this.exifModel;
    }

    @Override
    public void setEXIF(EXIFModel value) {
        this.exifModel = value;
    }

    @Override
    public CameraModel getCamera() {
        return this.cameraModel;
    }

    @Override
    public void setCamera(CameraModel value) {
        this.cameraModel = value;
    }
}
