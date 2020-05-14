package at.technikum.PresentationModel;

import at.technikum.interfaces.ISORatings;
import at.technikum.interfaces.presentationmodels.CameraPresentationModel;
import at.technikum.interfaces.presentationmodels.EXIFPresentationModel;

public class EXIFPresentationModelImpl implements EXIFPresentationModel {


    @Override
    public String getMake() {
        return null;
    }

    @Override
    public double getFNumber() {
        return 0;
    }

    @Override
    public double getExposureTime() {
        return 0;
    }

    @Override
    public double getISOValue() {
        return 0;
    }

    @Override
    public boolean getFlash() {
        return false;
    }

    @Override
    public String getExposureProgram() {
        return null;
    }

    @Override
    public String getExposureProgramResource() {
        return null;
    }

    @Override
    public CameraPresentationModel getCamera() {
        return null;
    }

    @Override
    public void setCamera(CameraPresentationModel value) {

    }

    @Override
    public ISORatings getISORating() {
        return null;
    }

    @Override
    public String getISORatingResource() {
        return null;
    }
}
