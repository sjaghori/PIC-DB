package at.technikum.Model;

import at.technikum.interfaces.ExposurePrograms;
import at.technikum.interfaces.models.EXIFModel;


public class EXIFModelImpl implements EXIFModel {
    private String cameraModel;
    private float apertureNumber;
    private float exposureTime;
    private float isoValue;
    private Boolean flash;


    @Override
    public String getMake() {
        return null;
    }

    @Override
    public void setMake(String value) {

    }

    @Override
    public double getFNumber() {
        return 0;
    }

    @Override
    public void setFNumber(double value) {

    }

    @Override
    public double getExposureTime() {
        return 0;
    }

    @Override
    public void setExposureTime(double value) {

    }

    @Override
    public double getISOValue() {
        return 0;
    }

    @Override
    public void setISOValue(double value) {

    }

    @Override
    public boolean getFlash() {
        return false;
    }

    @Override
    public void setFlash(boolean value) {

    }

    @Override
    public ExposurePrograms getExposureProgram() {
        return null;
    }

    @Override
    public void setExposureProgram(ExposurePrograms value) {

    }
}
