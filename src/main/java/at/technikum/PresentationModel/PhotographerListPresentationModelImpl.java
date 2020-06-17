package at.technikum.PresentationModel;

import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.presentationmodels.PhotographerListPresentationModel;

import java.util.ArrayList;
import java.util.Collection;

public class PhotographerListPresentationModelImpl implements PhotographerListPresentationModel {

    private Collection<PhotographerModel> photographerModels;

    public PhotographerListPresentationModelImpl(Collection<PhotographerModel> photographerModels) {
        this.photographerModels = photographerModels;
        refresh(photographerModels);
    }

    public void refresh(Collection<PhotographerModel> photographerModels) {
        this.photographerModels = photographerModels;
    }


    @Override
    public Collection<PhotographerModel> getList() {
        return photographerModels;
    }

    @Override
    public PhotographerModel getCurrentPhotographer(int index) {
        ArrayList<PhotographerModel> newList = new ArrayList<>(photographerModels);
        return newList.get(index);
    }

    @Override
    public void updatePhotographer(int index, PhotographerModel photographerModel) {
        ArrayList<PhotographerModel> oldList = new ArrayList<>(photographerModels);
        oldList.set(index, photographerModel);
        this.photographerModels = oldList;
    }
}
