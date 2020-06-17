package at.technikum.PresentationModel;

import at.technikum.Utils.Configurations;
import at.technikum.interfaces.models.PictureModel;
import at.technikum.interfaces.presentationmodels.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PicturePresentationModelImpl implements PicturePresentationModel {

    private ObjectProperty<Image> image = new SimpleObjectProperty<>();


    PictureModel pictureModel;
    IPTCPresentationModel iptcPresentationModel;
    EXIFPresentationModel exifPresentationModel;
    PhotographerPresentationModel photographerPresentationModel;

    PicturePresentationModelImpl(PictureModel pictureModel) {
        this.pictureModel = pictureModel;
        //iptcPresentationModel = new IPTCPresentationModelImpl(pictureModel.getIPTC());
        //exifPresentationModel = new EXIFPresentationModelImpl(pictureModel.getEXIF());
        // photographerPresentationModel
        loadImage(pictureModel);
    }

    @Override
    public void refresh(PictureModel pic) {
        this.pictureModel = pic;
        //exifPresentationModel.refresh(pic.getExif());
        //iptcPresentationModel.refresh(pic.getIptc());
        //photographerPresentationModel.refresh(pic.getPhotographer());
        loadImage(pic);
    }


    private void loadImage(PictureModel pic) {
        Properties properties = Configurations.readProperties();
        String imageFolderPath;
        if (properties.getProperty("img.folder") == null || properties.getProperty("img.folder").isEmpty()) {
            imageFolderPath = "./images";
        } else {
            imageFolderPath = properties.getProperty("img.folder");
        }

        try {
            String path = imageFolderPath + System.getProperty("file.separator") + pic.getFileName();
            Image image = new Image(new FileInputStream(path));
            this.image.set(image);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PictureModel getUpdatedModel() {

        // TODO: save iptc
        // TODO: save exif not really

        refresh(pictureModel);
        return pictureModel;
    }


    @Override
    public int getID() {
        return this.pictureModel.getID();
    }

    @Override
    public String getFileName() {
        return this.pictureModel.getFileName();
    }

    @Override
    public String getFilePath() {
        return this.pictureModel.getFileName();
    }

    @Override
    public String getDisplayName() {
        try {
            return this.pictureModel.getFileName().split(",")[0];
        } catch (IllegalStateException e) {
            return this.pictureModel.getFileName();
        }
    }

    @Override
    public IPTCPresentationModel getIPTC() {
        return this.iptcPresentationModel;
    }

    @Override
    public EXIFPresentationModel getEXIF() {
        return this.exifPresentationModel;
    }

    @Override
    public PhotographerPresentationModel getPhotographer() {
        return this.photographerPresentationModel;
    }

    public ObjectProperty<Image> imageProperty() {
        return image;
    }

}
