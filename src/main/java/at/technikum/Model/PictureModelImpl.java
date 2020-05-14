package at.technikum.Model;

import at.technikum.interfaces.models.CameraModel;
import at.technikum.interfaces.models.EXIFModel;
import at.technikum.interfaces.models.IPTCModel;
import at.technikum.interfaces.models.PictureModel;

public class PictureModelImpl implements PictureModel {


    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void setID(int value) {

    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public void setFileName(String value) {

    }

    @Override
    public IPTCModel getIPTC() {
        return null;
    }

    @Override
    public void setIPTC(IPTCModel value) {

    }

    @Override
    public EXIFModel getEXIF() {
        return null;
    }

    @Override
    public void setEXIF(EXIFModel value) {

    }

    @Override
    public CameraModel getCamera() {
        return null;
    }

    @Override
    public void setCamera(CameraModel value) {

    }
}
