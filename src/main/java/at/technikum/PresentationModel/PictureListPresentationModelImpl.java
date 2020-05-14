package at.technikum.PresentationModel;

import at.technikum.interfaces.presentationmodels.PictureListPresentationModel;
import at.technikum.interfaces.presentationmodels.PicturePresentationModel;

import java.util.Collection;

public class PictureListPresentationModelImpl implements PictureListPresentationModel {

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
