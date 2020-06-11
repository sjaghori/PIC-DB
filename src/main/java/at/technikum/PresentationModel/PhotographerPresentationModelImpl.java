package at.technikum.PresentationModel;

import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;

import java.time.LocalDate;

public class PhotographerPresentationModelImpl implements PhotographerPresentationModel {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private ObjectProperty<LocalDate> birthday = new SimpleObjectProperty<>();
    private StringProperty notes = new SimpleStringProperty();
    private BooleanBinding incorrectBirthday;

    private PhotographerModel photographerModel;

    public PhotographerPresentationModelImpl() {
        //super();

    }

    PhotographerPresentationModelImpl(PhotographerModel photographer) {
        this();
        refresh(photographer);
    }


    public void refresh(PhotographerModel photographer) {
        this.photographerModel = photographer;
        firstName.setValue(photographer.getFirstName());
        lastName.setValue(photographer.getLastName());
        birthday.setValue(photographer.getBirthDay());
        notes.setValue(photographer.getNotes());
    }

    public void updateModel() {
        photographerModel.setFirstName(this.getFirstName());
        photographerModel.setLastName(this.getLastName());
        photographerModel.setBirthDay(birthday.get());
        photographerModel.setNotes(notes.get());
    }

    @Override
    public int getID() {
        return id.get();
    }

    @Override
    public String getFirstName() {
        return firstName.get() != null ? firstName.get() : "";
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    @Override
    public String getLastName() {
        return lastName.get() != null ? lastName.get() : "";
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    @Override
    public LocalDate getBirthDay() {
        return birthday.get() != null ? birthday.get() : LocalDate.of(1998,8,12);
    }

    @Override
    public void setBirthDay(LocalDate value) {
        this.birthday.set(value);
    }

    public StringProperty notesProperty() {
        return notes;
    }

    @Override
    public String getNotes() {
        return notes.get() != null ? notes.get() : "";
    }

    @Override
    public void setNotes(String value) {
        this.notes.set(value);
    }

    @Override
    public int getNumberOfPictures() {
        return 0;
    }

    public BooleanBinding cannotSaveProperty() {
        return Bindings.or(lastName.isEmpty(), incorrectBirthday);
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
