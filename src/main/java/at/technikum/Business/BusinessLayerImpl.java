package at.technikum.Business;

import at.technikum.DataAccessLayer.DALFactory;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.DataAccessLayer;
import at.technikum.interfaces.models.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class BusinessLayerImpl implements BusinessLayer {

    private final DataAccessLayer _dal;

    private static BusinessLayerImpl instance = null;

    public static BusinessLayerImpl getInstance() {
        if (instance == null)
            instance = new BusinessLayerImpl();

        return instance;
    }

    public BusinessLayerImpl() {
        // DALFactory.useMock(); // verwenden um DAL zu mocken, für die Unit Tests
        this._dal = DALFactory.getDAL();
    }


    @Override
    public Collection<PictureModel> getPictures() {
        return _dal.getPictures();
    }

    @Override
    public List<PictureModel> getPictures(String searchText) {
        return _dal.getPictures(searchText);
    }

    @Override
    public PictureModel getPicture(int ID) {
        return _dal.getPicture(ID);
    }

    @Override
    public void updatePicture(PictureModel picture) {
        _dal.updatePicture(picture);
    }

    @Override
    public void save(PictureModel picture) {
        _dal.save(picture);
    }

    @Override
    public void deletePicture(int ID) {
        _dal.deletePicture(ID);
    }

    @Override
    public void sync() {

    }

    @Override
    public Collection<PhotographerModel> getPhotographers() {
        return _dal.getPhotographers();
    }

    @Override
    public PhotographerModel getPhotographer(int ID) {
        return _dal.getPhotographer(ID);
    }

    @Override
    public void save(PhotographerModel photographer) {
        _dal.save(photographer);
    }

    @Override
    public void deletePhotographer(int ID) {
        _dal.deletePhotographer(ID);
    }

    @Override
    public void updatePhotographer(PhotographerModel photographer, int index) {
        _dal.updatePhotographer(photographer, index);
    }

    @Override
    public void changePhotographer(PictureModel pictureModel, PhotographerModel photographerModel) {
        _dal.changePhotographer(pictureModel, photographerModel);
    }

    @Override
    public IPTCModel extractIPTC(String filename) {
        return null;
    }

    @Override
    public EXIFModel extractEXIF(String filename) {
        return null;
    }

    @Override
    public void writeIPTC(String filename, IPTCModel iptc) {
    }

    @Override
    public Set<String> getDistinctKeyword() {
        return _dal.getDistinctKeyword();
    }

    @Override
    public int getKeywordsCount(String keyword) {
        return _dal.getKeywordsCount(keyword);
    }
}
