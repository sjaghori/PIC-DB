package at.technikum.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EXIFModel {
    private String cameraModel;
    private float apertureNumber;
    private float exposureTime;
    private float isoValue;
    private Boolean flash;
}
