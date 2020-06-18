package at.technikum.PresentationModel;

import at.technikum.Business.BusinessLayerImpl;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.models.PictureModel;
import at.technikum.interfaces.presentationmodels.SearchPresentationModel;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SearchPresentationModelImpl implements SearchPresentationModel {
    private static final Logger logger = LogManager.getLogger(SearchPresentationModelImpl.class);
    BusinessLayer dal = BusinessLayerImpl.getInstance();

    private StringProperty searchText = new SimpleStringProperty();

    private BooleanBinding activeSearch;

    public SearchPresentationModelImpl() {
        searchText.addListener((s,o,n) -> activeSearch.invalidate());

        activeSearch = new BooleanBinding() {
            @Override
            protected boolean computeValue() {
                return !getSearchText().isEmpty();
            }
        };
    }

    public StringProperty searchTextProperty() {
        return this.searchText;
    }

    @Override
    public List<PictureModel> getSearchedPictures() {
        String searchText = getSearchText();
        return dal.getPictures(searchText);
    }

    @Override
    public String getSearchText() {
        return this.searchText.get() != null ? this.searchText.get() : "";
    }

    @Override
    public boolean getIsActive() {
        return activeSearch.get();
    }

    @Override
    public int getResultCount() {
        return 0;
    }
}