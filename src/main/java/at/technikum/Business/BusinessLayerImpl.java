package at.technikum.Business;

import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.models.*;

import java.util.Collection;

public class BusinessLayerImpl implements BusinessLayer {

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
    public void sync() throws Exception {

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

    @Override
    public IPTCModel extractIPTC(String filename) throws Exception {
        return null;
    }

    @Override
    public EXIFModel extractEXIF(String filename) throws Exception {
        return null;
    }

    @Override
    public void writeIPTC(String filename, IPTCModel iptc) throws Exception {

    }

    @Override
    public Collection<CameraModel> getCameras() {
        return null;
    }

    @Override
    public CameraModel getCamera(int ID) {
        return null;
    }
}
