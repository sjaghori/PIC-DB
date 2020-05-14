package at.technikum.Model;

import at.technikum.interfaces.ExposurePrograms;
import at.technikum.interfaces.models.EXIFModel;


public class EXIFModelImpl implements EXIFModel {

    private String cameraModel;
    private String make;
    private double fNumber;
    private double exposureTime;
    private double isoValue;
    private float apertureNumber;
    private Boolean flash;
    private ExposurePrograms exposurePrograms;


    @Override
    public String getMake() {
        return this.make;
    }

    @Override
    public void setMake(String value) {
        this.make = value;
    }

    @Override
    public double getFNumber() {
        return this.fNumber;
    }

    @Override
    public void setFNumber(double value) {
        this.fNumber = value;
    }

    @Override
    public double getExposureTime() {
        return this.exposureTime;
    }

    @Override
    public void setExposureTime(double value) {
        this.exposureTime = value;
    }

    @Override
    public double getISOValue() {
        return this.isoValue;
    }

    @Override
    public void setISOValue(double value) {
        this.isoValue = value;
    }

    @Override
    public boolean getFlash() {
        return false;
    }

    @Override
    public void setFlash(boolean value) {
        this.flash = value;
    }

    @Override
    public ExposurePrograms getExposureProgram() {
        return this.exposurePrograms;
    }

    @Override
    public void setExposureProgram(ExposurePrograms value) {
        this.exposurePrograms = value;
    }
}