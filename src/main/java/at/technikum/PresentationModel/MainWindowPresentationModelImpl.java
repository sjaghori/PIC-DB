package at.technikum.PresentationModel;

import at.technikum.interfaces.presentationmodels.MainWindowPresentationModel;
import at.technikum.interfaces.presentationmodels.PictureListPresentationModel;
import at.technikum.interfaces.presentationmodels.PicturePresentationModel;
import at.technikum.interfaces.presentationmodels.SearchPresentationModel;

public class MainWindowPresentationModelImpl implements MainWindowPresentationModel {


    @Override
    public PicturePresentationModel getCurrentPicture() {
        return null;
    }

    @Override
    public PictureListPresentationModel getList() {
        return null;
    }

    @Override
    public SearchPresentationModel getSearch() {
        return null;
    }
}
