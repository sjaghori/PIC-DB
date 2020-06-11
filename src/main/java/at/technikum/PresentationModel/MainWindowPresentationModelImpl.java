package at.technikum.PresentationModel;

import at.technikum.interfaces.presentationmodels.MainWindowPresentationModel;
import at.technikum.interfaces.presentationmodels.PictureListPresentationModel;
import at.technikum.interfaces.presentationmodels.PicturePresentationModel;
import at.technikum.interfaces.presentationmodels.SearchPresentationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainWindowPresentationModelImpl implements MainWindowPresentationModel {
    private static final Logger logger = LogManager.getLogger(MainWindowPresentationModelImpl.class);

    // DATABASE private PictureServiceMock ps = PictureServiceMock.getInstance();
    private int selectedIndex = 0;

    // Children View Models
    private PicturePresentationModel picturePresentationModel = new PicturePresentationModelImpl();
    private PictureListPresentationModel pictureListPresentationModel = new PictureListPresentationModelImpl();
    private SearchPresentationModel searchPresentationModel = new SearchPresentationModelImpl();


    @Override
    public PicturePresentationModel getCurrentPicture() {
        return this.picturePresentationModel;
    }

    @Override
    public PictureListPresentationModel getList() {
        return this.pictureListPresentationModel;
    }

    @Override
    public SearchPresentationModel getSearch() {
        return this.searchPresentationModel;
    }
}
