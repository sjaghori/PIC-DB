import at.technikum.Business.BusinessLayerImpl;
import at.technikum.Model.PictureModelImpl;
import at.technikum.PresentationModel.PhotographerPresentationModelImpl;
import at.technikum.Utils.Configurations;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Properties;

public class PIC_DB_Test {


    @Test
    public void businesslayer_should_return_pictureModel_of_id_1() {
        BusinessLayer dal = BusinessLayerImpl.getInstance();
        Assert.assertEquals(dal.getPicture(1).getFileName(), "parrot.jpg");
    }

    @Test
    public void businesslayer_should_return_photographer_of_id_1() {
        BusinessLayer dal = BusinessLayerImpl.getInstance();
        Assert.assertEquals(dal.getPhotographer(1).getLastName(), "Jaghori");
    }

    @Test
    public void can_read_configuration() {
        Properties properties = Configurations.readProperties();
        Assert.assertEquals(properties.getProperty("img.folder"), "./images");
    }

    @Test
    public void return_list_of_pictures() {
        BusinessLayer dal = BusinessLayerImpl.getInstance();
        Assert.assertNotNull(dal.getPictures());
    }

    @Test
    public void businesslayer_should_return_list_of_tags() {
        BusinessLayer dal = BusinessLayerImpl.getInstance();
        Assert.assertNotNull(dal.getDistinctKeyword());
    }

    @Test
    public void businesslayer_returns_list_of_photographers() {
        BusinessLayer dal = BusinessLayerImpl.getInstance();
        Assert.assertNotNull(dal.getPhotographers());
    }

    @Test
    public void photographer_presentationmodel_should_validate_birthdate() {
        BusinessLayer dal = BusinessLayerImpl.getInstance();
        PhotographerModel photographerModel = dal.getPhotographer(1);
        Assert.assertNotNull(photographerModel);
        PhotographerPresentationModel photographerPresentationModel = new PhotographerPresentationModelImpl(photographerModel);
        photographerModel.setBirthDay(LocalDate.of(1998,8,12));
        photographerPresentationModel.isValidBirthDay();
    }

    @Test
    public void photographer_presentationmodel_should_validate_lastname() {
        BusinessLayer dal = BusinessLayerImpl.getInstance();
        PhotographerModel photographerModel = dal.getPhotographer(1);
        Assert.assertNotNull(photographerModel);
        PhotographerPresentationModel photographerPresentationModel = new PhotographerPresentationModelImpl(photographerModel);
        Assert.assertTrue(photographerPresentationModel.isValidLastName());
    }

    @Test
    public void photographer_presentationmodel_should_validate_both() {
        BusinessLayer dal = BusinessLayerImpl.getInstance();
        PhotographerModel photographerModel = dal.getPhotographer(1);
        Assert.assertNotNull(photographerModel);
        PhotographerPresentationModel photographerPresentationModel = new PhotographerPresentationModelImpl(photographerModel);
        Assert.assertTrue(photographerPresentationModel.isValid());
    }

    @Test
    public void photographer_presentationmodel_should_return_notes() {
        BusinessLayer dal = BusinessLayerImpl.getInstance();
        PhotographerModel photographerModel = dal.getPhotographer(1);
        Assert.assertNotNull(photographerModel);
        PhotographerPresentationModel photographerPresentationModel = new PhotographerPresentationModelImpl(photographerModel);
        Assert.assertEquals(photographerPresentationModel.getFirstName(), "Sasan");
    }



}
