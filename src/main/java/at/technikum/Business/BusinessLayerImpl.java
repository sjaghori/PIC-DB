package at.technikum.Business;

import at.technikum.DataAccessLayer.DALFactory;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.DataAccessLayer;
import at.technikum.interfaces.models.*;

import java.util.Collection;

public class BusinessLayerImpl implements BusinessLayer {

    private DataAccessLayer _dal;

    public BusinessLayerImpl() {
        // DALFactory.useMock(); // verwenden um DAL zu mocken, für die Unit Tests
        this._dal = DALFactory.getDAL();
    }


    @Override
    public Collection<PictureModel> getPictures() throws Exception {
        return _dal.getPictures();
    }

    @Override
    public Collection<PictureModel> getPictures(String namePart, PhotographerModel photographerParts, IPTCModel iptcParts, EXIFModel exifParts) throws Exception {
        return _dal.getPictures(namePart, photographerParts, iptcParts, exifParts);
    }

    @Override
    public PictureModel getPicture(int ID) throws Exception {
        return _dal.getPicture(ID);
    }

    @Override
    public void save(PictureModel picture) throws Exception {
        _dal.save(picture);
    }

    @Override
    public void deletePicture(int ID) throws Exception {
        _dal.deletePicture(ID);
    }

    @Override
    public void sync() throws Exception {

    }

    @Override
    public Collection<PhotographerModel> getPhotographers() throws Exception {
        return _dal.getPhotographers();
    }

    @Override
    public PhotographerModel getPhotographer(int ID) throws Exception {
        return _dal.getPhotographer(ID);
    }

    @Override
    public void save(PhotographerModel photographer) throws Exception {
        _dal.save(photographer);
    }

    @Override
    public void deletePhotographer(int ID) throws Exception {
        _dal.deletePhotographer(ID);
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
        return _dal.getCameras();
    }

    @Override
    public CameraModel getCamera(int ID) {
        return _dal.getCamera(ID);
    }
}
