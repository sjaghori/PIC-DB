package at.technikum.PresentationModel;

import at.technikum.interfaces.presentationmodels.SearchPresentationModel;

public class SearchPresentationModelImpl implements SearchPresentationModel {

    @Override
    public String getSearchText() {
        return null;
    }

    @Override
    public void setSearchText(String value) {

    }

    @Override
    public boolean getIsActive() {
        return false;
    }

    @Override
    public int getResultCount() {
        return 0;
    }
}
