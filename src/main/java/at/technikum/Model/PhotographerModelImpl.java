package at.technikum.Model;

import at.technikum.interfaces.models.PhotographerModel;

import java.time.LocalDate;
import java.util.Date;


public class PhotographerModelImpl implements PhotographerModel {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String notes;


    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void setID(int value) {

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
}