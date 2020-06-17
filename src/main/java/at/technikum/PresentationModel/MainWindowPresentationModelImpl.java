package at.technikum.PresentationModel;

import at.technikum.Business.BusinessLayerImpl;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.models.PictureModel;
import at.technikum.interfaces.presentationmodels.MainWindowPresentationModel;
import at.technikum.interfaces.presentationmodels.PictureListPresentationModel;
import at.technikum.interfaces.presentationmodels.PicturePresentationModel;
import at.technikum.interfaces.presentationmodels.SearchPresentationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainWindowPresentationModelImpl implements MainWindowPresentationModel {
    private static final Logger logger = LogManager.getLogger(MainWindowPresentationModelImpl.class);

    private int selectedIndex = 1;
    private BusinessLayer dal = BusinessLayerImpl.getInstance();

    private static MainWindowPresentationModelImpl instance = null;
    public static MainWindowPresentationModelImpl getInstance() {
        if (instance == null)
            instance = new MainWindowPresentationModelImpl();
        return instance;
    }

    // Presentation Models
    private PicturePresentationModel picturePresentationModel = new PicturePresentationModelImpl(dal.getPicture(selectedIndex));
    private PictureListPresentationModel pictureListPresentationModel = new PictureListPresentationModelImpl(dal.getPictures());
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

    @Override
    public void selectPicture(int selectedIndex) {
        /*if(selectedIndex != -1) {
            if (activeSearch.get()) {
                String searchText = searchViewModel.searchTextProperty().get();*/
                //PictureModel pictureModel = ps.getPictureOfSearchResult(searchText, selectedIndex);
                //pictureViewModel.refresh(pictureModel);
                //logger.info("Selected image in search results with index: " + selectedIndex);
            //} else {
                picturePresentationModel.refresh(dal.getPicture(selectedIndex));
                //logger.info("Selected image with index: " + selectedIndex);
            //}
            this.selectedIndex = selectedIndex;
        }
    //}

    public void saveChanges() {
        PictureModel pic = picturePresentationModel.getUpdatedModel();
        dal.updatePicture(pic);
        picturePresentationModel.refresh(pic);
    }



    /*
    public void loadAllPictures() {
        pictureViewModel.refresh(ps.getPicture(selectedIndex));
        pictureListViewModel.refresh(ps.getAllPictures());
        logger.info("Reloaded all images");
    }

    public void loadSearchedPictures() {
        String searchText = searchViewModel.searchTextProperty().get();
        List<PictureModel> searchResult = ps.searchPictures(searchText);

        logger.info("Searched for: " + searchText + "\nFound: " + searchResult);

        pictureViewModel.refresh(searchResult.get(0));
        pictureListViewModel.refresh(searchResult);
    }*/
}
