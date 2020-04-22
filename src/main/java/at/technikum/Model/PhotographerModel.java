package at.technikum.Model;

import lombok.*;

import java.util.Date;

@Getter @Setter
@ToString @EqualsAndHashCode
public class PhotographerModel {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String notes;
}