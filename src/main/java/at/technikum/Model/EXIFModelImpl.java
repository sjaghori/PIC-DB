package at.technikum.Model;

import at.technikum.interfaces.ExposurePrograms;
import at.technikum.interfaces.models.EXIFModel;


public class EXIFModelImpl implements EXIFModel {

    private String make;                        // or Vendor, Manufacturer
    private double fNumber;                     // f/1.4, f/2, f/2.8, f/4, f/5.6, f/8
    private double exposureTime;                // in seconds e.g. 1/250 sec
    private double isoValue;                    // e.g. 100, 200, 400, 800
    private Boolean flash;                      // yes or no
    private ExposurePrograms exposurePrograms;  // e.g. LandscapeMode, Normal


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
        return this.flash;
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