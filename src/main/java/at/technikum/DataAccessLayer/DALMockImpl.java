package at.technikum.DataAccessLayer;

import at.technikum.interfaces.DataAccessLayer;
import at.technikum.interfaces.models.*;

import java.util.Collection;

public class DALMockImpl implements DataAccessLayer {

    private static DALMockImpl instance = new DALMockImpl();

    public static DALMockImpl getInstance() {
        return instance;
    }

    @Override
    public Collection<PictureModel> getPictures() {
        return null;
    }

    @Override
    public Collection<PictureModel> getPictures(String namePart, PhotographerModel photographerParts,
                                                IPTCModel iptcParts, EXIFModel exifParts) throws Exception {
        return null;
    }

    @Override
    public PictureModel getPicture(int ID) {
        return null;
    }

    @Override
    public void save(PictureModel picture) {

    }

    @Override
    public void deletePicture(int ID) {

    }

    @Override
    public Collection<PhotographerModel> getPhotographers() {
        return null;
    }

    @Override
    public PhotographerModel getPhotographer(int ID) {
        return null;
    }

    @Override
    public void save(PhotographerModel photographer) {

    }

    @Override
    public void deletePhotographer(int ID) {

    }

    @Override
    public void updatePhotographer(PhotographerModel photographer, int index) {

    }
}
