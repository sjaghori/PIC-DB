package at.technikum.PresentationModel;

import at.technikum.Utils.Configurations;
import at.technikum.interfaces.models.PictureModel;
import at.technikum.interfaces.presentationmodels.PictureListPresentationModel;
import at.technikum.interfaces.presentationmodels.PicturePresentationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PictureListPresentationModelImpl implements PictureListPresentationModel {

    private static final Logger logger = LogManager.getLogger(PictureListPresentationModelImpl.class);
    private ObservableList<ImageView> pics = FXCollections.observableArrayList();

    public PictureListPresentationModelImpl(Collection<PictureModel> pictureList) {
        refresh(pictureList);
    }

    public void refresh(Collection<PictureModel> pictureList) {
        this.pics.clear();
        Properties properties = Configurations.readProperties();
        String imageFolderPath;
        if (properties.getProperty("img.folder") == null || properties.getProperty("img.folder").isEmpty()) {
            imageFolderPath = "./images";
        } else {
            imageFolderPath = properties.getProperty("img.folder");
        }
        for (PictureModel pic : pictureList) {
            try {
                String path = imageFolderPath + System.getProperty("file.separator") + pic.getFileName();
                Image image = new Image(new FileInputStream(path));
                ImageView imView = new ImageView(image);
                imView.setFitHeight(205);
                imView.setPreserveRatio(true);
                this.pics.add(imView);
            } catch (FileNotFoundException e) {
                logger.error("File Error: " + e.getMessage());
            }
        }
    }


    @Override
    public ObservableList<ImageView> getpics() {
        return this.pics;
    }

    @Override
    public PicturePresentationModel getCurrentPicture() {
        return null;
    }

    @Override
    public Collection<PicturePresentationModel> getList() {
        return null;
    }

    @Override
    public Collection<PicturePresentationModel> getPrevPictures() {
        return null;
    }

    @Override
    public Collection<PicturePresentationModel> getNextPictures() {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public int getCurrentIndex() {
        return 0;
    }

    @Override
    public String getCurrentPictureAsString() {
        return null;
    }
}
