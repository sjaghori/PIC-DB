package at.technikum.Model;

import at.technikum.interfaces.models.PhotographerModel;

import java.time.LocalDate;


public class PhotographerModelImpl implements PhotographerModel {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String notes;


    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void setID(int value) {
        this.id = value;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String value) {
        this.firstName = value;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String value) {
        this.lastName = value;
    }

    @Override
    public LocalDate getBirthDay() {
        return this.birthday;
    }

    @Override
    public void setBirthDay(LocalDate value) {
        this.birthday = value;
    }

    @Override
    public String getNotes() {
        return this.notes;
    }

    @Override
    public void setNotes(String value) {
        this.notes = value;
    }

    @Override
    public String toString() {
        return lastName;
    }
}