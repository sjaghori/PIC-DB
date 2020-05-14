package at.technikum.PresentationModel;

import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;

import java.time.LocalDate;

public class PhotographerPresentationModelImpl implements PhotographerPresentationModel {

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public void setFirstName(String value) {

    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setLastName(String value) {

    }

    @Override
    public LocalDate getBirthDay() {
        return null;
    }

    @Override
    public void setBirthDay(LocalDate value) {

    }

    @Override
    public String getNotes() {
        return null;
    }

    @Override
    public void setNotes(String value) {

    }

    @Override
    public int getNumberOfPictures() {
        return 0;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String getValidationSummary() {
        return null;
    }

    @Override
    public boolean isValidLastName() {
        return false;
    }

    @Override
    public boolean isValidBirthDay() {
        return false;
    }
}
