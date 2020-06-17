package at.technikum.PresentationModel;

import at.technikum.Business.BusinessLayerImpl;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.presentationmodels.PhotographerListPresentationModel;
import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;

public class PhotographerManagerPresentationModel {

    private int selectedIndex = 1;
    private BusinessLayer dal = BusinessLayerImpl.getInstance();

    private PhotographerListPresentationModel photographerListPresentationModel = new PhotographerListPresentationModelImpl(dal.getPhotographers());
    private PhotographerPresentationModel photographerPresentationModel = new PhotographerPresentationModelImpl(dal.getPhotographer(selectedIndex));

    public PhotographerListPresentationModel getPhotographerListPresentationModel() {
        return photographerListPresentationModel;
    }
    public PhotographerPresentationModel getPhotographerPresentationModel() {
        return photographerPresentationModel;
    }


    public void selectPhotographer(int newIndex) {
        selectedIndex = newIndex;
        if(selectedIndex != -1)
            photographerPresentationModel.refresh(dal.getPhotographer(selectedIndex));
    }

    public void updateDatabase() {
        photographerPresentationModel.update();
        PhotographerModel updatedModel = photographerPresentationModel.getPhotographerModel();
        dal.updatePhotographer(updatedModel, selectedIndex);
        photographerListPresentationModel.updatePhotographer(selectedIndex - 1, updatedModel);
    }

}
