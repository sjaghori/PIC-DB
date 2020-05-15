package at.technikum.DataAccessLayer;

import at.technikum.Model.PictureModelImpl;
import at.technikum.interfaces.DataAccessLayer;
import at.technikum.interfaces.models.*;

import java.sql.*;
import java.util.Arrays;
import java.util.Collection;

public class DALImpl implements DataAccessLayer {

    private Connection connection;

    DALImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Collection<PictureModel> getPictures() throws Exception {
        return null;
    }

    @Override
    public Collection<PictureModel> getPictures(String namePart, PhotographerModel photographerParts,
                                                IPTCModel iptcParts, EXIFModel exifParts) throws Exception {
        return null;
    }

    @Override
    public PictureModel getPicture(int ID) {
        String query = "select id, name, pic_path from Picture where id=?";
        PictureModel pictureModel = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pictureModel = new PictureModelImpl(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("pic_path"));
            }
        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return pictureModel;
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

    @Override
    public Collection<CameraModel> getCameras() {
        return null;
    }

    @Override
    public CameraModel getCamera(int ID) {
        return null;
    }
}
