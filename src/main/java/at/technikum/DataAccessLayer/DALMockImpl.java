package at.technikum.DataAccessLayer;

import at.technikum.interfaces.DataAccessLayer;
import at.technikum.interfaces.models.*;

import java.util.Collection;

public class DALMockImpl implements DataAccessLayer {
    @Override
    public Collection<PictureModel> getPictures() throws Exception {
        return null;
    }

    @Override
    public Collection<PictureModel> getPictures(String namePart, PhotographerModel photographerParts, IPTCModel iptcParts, EXIFModel exifParts) throws Exception {
        return null;
    }

    @Override
    public PictureModel getPicture(int ID) throws Exception {
        return null;
    }

    @Override
    public void save(PictureModel picture) throws Exception {

    }

    @Override
    public void deletePicture(int ID) throws Exception {

    }

    @Override
    public Collection<PhotographerModel> getPhotographers() throws Exception {
        return null;
    }

    @Override
    public PhotographerModel getPhotographer(int ID) throws Exception {
        return null;
    }

    @Override
    public void save(PhotographerModel photographer) throws Exception {

    }

    @Override
    public void deletePhotographer(int ID) throws Exception {

    }
}
