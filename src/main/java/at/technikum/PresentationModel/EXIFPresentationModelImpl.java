package at.technikum.PresentationModel;

import at.technikum.interfaces.presentationmodels.EXIFPresentationModel;
import javafx.beans.property.*;

public class EXIFPresentationModelImpl implements EXIFPresentationModel {

    private StringProperty make = new SimpleStringProperty();
    private StringProperty exposureTime = new SimpleStringProperty();
    private StringProperty isoValue = new SimpleStringProperty();
    private StringProperty fNumber = new SimpleStringProperty();
    private BooleanProperty flash = new SimpleBooleanProperty();
    private StringProperty exposurePrograms = new SimpleStringProperty();

    public StringProperty makeProperty() {
        return this.make;
    }

    @Override
    public String getMake() {
        return this.make.get() != null ? this.make.get() : "";
    }

    public StringProperty fNumberProperty(){
        return this.fNumber;
    }

    /*public void setMake() {
        this.make.set("Canon XY");
    }*/

    @Override
    public double getFNumber() {
        return Double.parseDouble(this.fNumber.get());
    }

    public StringProperty exposureTimeProperty(){
        return this.exposureTime;
    }

    @Override
    public double getExposureTime() {
        return Double.parseDouble(this.exposureTime.get());
    }

    public StringProperty isoValueProperty(){
        return this.isoValue;
    }

    @Override
    public double getISOValue() {
        return Double.parseDouble(this.isoValue.get());
    }

    public BooleanProperty flashProperty(){
        return this.flash;
    }

    @Override
    public boolean getFlash() {
        return this.flash.get();
    }

    public StringProperty exposureProgramsProperty(){
        return this.exposurePrograms;
    }

    @Override
    public String getExposureProgram() {
        return this.exposurePrograms.get() != null ? this.exposurePrograms.get() : "";
    }

    @Override
    public String getExposureProgramResource() {
        return null;
    }

}
