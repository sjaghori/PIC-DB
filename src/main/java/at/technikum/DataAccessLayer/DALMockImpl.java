package at.technikum.DataAccessLayer;

import at.technikum.interfaces.DataAccessLayer;
import at.technikum.interfaces.models.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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
    public List<PictureModel> getPictures(String searchText) {
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
    public void updatePicture(PictureModel picture) {

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

    @Override
    public void changePhotographer(PictureModel pictureModel, PhotographerModel photographerModel) {

    }

    @Override
    public Set<String> getDistinctKeyword() {
        return null;
    }

    @Override
    public int getKeywordsCount(String keyword) {
        return 0;
    }
}
