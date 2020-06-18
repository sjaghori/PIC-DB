package at.technikum.DataAccessLayer;

import at.technikum.Model.EXIFModelImpl;
import at.technikum.Model.IPTCModelImpl;
import at.technikum.Model.PhotographerModelImpl;
import at.technikum.Model.PictureModelImpl;
import at.technikum.interfaces.DataAccessLayer;
import at.technikum.interfaces.ExposurePrograms;
import at.technikum.interfaces.models.*;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import javafx.beans.property.StringProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DALImpl implements DataAccessLayer {
    private static DALImpl instance = new DALImpl(Database.getConnection());

    private static final Logger logger = LogManager.getLogger(DALImpl.class);

    private Connection connection;

    DALImpl(Connection connection) {
        this.connection = connection;
    }


    public static DALImpl getInstance() {
        return instance;
    }

    @Override
    public Collection<PictureModel> getPictures() {
        String query = "select * from picture " +
                "JOIN iptc i on picture.id = i.fk_picture_id " +
                "JOIN exif e on picture.id = e.fk_picture_id " +
                "JOIN photographer p on picture.fk_photographer = p.id";
        List<PictureModel> pictureList = new ArrayList<>();
        PictureModel pictureModel = null;
        EXIFModel exifModel = null;
        IPTCModel iptcModel = null;
        PhotographerModel photographerModel = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pictureModel = new PictureModelImpl(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("pic_path"));
                exifModel = new EXIFModelImpl();
                createEXIF(exifModel, resultSet);

                iptcModel = new IPTCModelImpl();
                createIPTC(iptcModel, resultSet);

                photographerModel = new PhotographerModelImpl();
                createPhotographer(resultSet, photographerModel);

                pictureModel.setEXIF(exifModel);
                pictureModel.setIPTC(iptcModel);
                pictureModel.setPhotographer(photographerModel);

                pictureList.add(pictureModel);
            }
        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }
        return pictureList;
    }

    private void createEXIF(EXIFModel exifModel, ResultSet resultSet) throws SQLException {
        exifModel.setMake(resultSet.getString("make"));
        ExposurePrograms exposurePrograms = ExposurePrograms.Normal;
        exifModel.setExposureProgram(exposurePrograms);
        exifModel.setFlash(resultSet.getBoolean("flash"));
        exifModel.setFNumber(resultSet.getFloat("fNumber"));
        exifModel.setISOValue(resultSet.getDouble("isoValue"));
        exifModel.setExposureTime(resultSet.getDouble("exposureTime"));
    }

    @Override
    public List<PictureModel> getPictures(String searchText) {
        List<PictureModel> pictureModels = new ArrayList<>();
        PictureModel pictureModel = null;
        EXIFModel exifModel = null;
        IPTCModel iptcModel = null;
        PhotographerModel photographerModel = null;
        String query = "SELECT * FROM picture " +
                "JOIN iptc on picture.id = iptc.fk_picture_id " +
                "JOIN exif e on picture.id = e.fk_picture_id " +
                "JOIN photographer p on picture.fk_photographer = p.id " +
                "WHERE keywords like ? or lastname like ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + searchText + "%");
            preparedStatement.setString(2, searchText);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pictureModel = new PictureModelImpl(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("pic_path"));

                exifModel = new EXIFModelImpl();
                createEXIF(exifModel, resultSet);


                iptcModel = new IPTCModelImpl();
                createIPTC(iptcModel, resultSet);

                photographerModel = new PhotographerModelImpl();
                createPhotographer(resultSet, photographerModel);

                pictureModel.setEXIF(exifModel);
                pictureModel.setIPTC(iptcModel);
                pictureModel.setPhotographer(photographerModel);
                pictureModels.add(pictureModel);
            }

        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }

        return pictureModels;
    }

    @Override
    public PictureModel getPicture(int ID) {
        // TODO: JOIN IPTC, EXIF
        String query = "select * from picture " +
                "JOIN iptc i on picture.id = i.fk_picture_id " +
                "JOIN exif e on picture.id = e.fk_picture_id " +
                "JOIN photographer p on picture.fk_photographer = p.id where picture.id=?";
        PictureModel pictureModel = null;
        EXIFModel exifModel = null;
        IPTCModel iptcModel = null;
        PhotographerModel photographerModel = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pictureModel = new PictureModelImpl(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("pic_path"));

                exifModel = new EXIFModelImpl();
                createEXIF(exifModel, resultSet);


                iptcModel = new IPTCModelImpl();
                createIPTC(iptcModel, resultSet);

                photographerModel = new PhotographerModelImpl();
                createPhotographer(resultSet, photographerModel);

                pictureModel.setEXIF(exifModel);
                pictureModel.setIPTC(iptcModel);
                pictureModel.setPhotographer(photographerModel);

            }
        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }
        return pictureModel;
    }

    private void createIPTC(IPTCModel iptcModel, ResultSet resultSet) throws SQLException {
        iptcModel.setCopyrightNotice(resultSet.getString("copyrightNotice"));
        iptcModel.setHeadline(resultSet.getString("headline"));
        iptcModel.setKeywords(resultSet.getString("keywords"));
    }

    @Override
    public void updatePicture(PictureModel picture) {

        IPTCModel iptcModel = picture.getIPTC();
        PhotographerModel photographerModel = picture.getPhotographer();

        String updateIPTC = "update iptc join picture p on iptc.fk_picture_id = p.id " +
                "set keywords = ?, copyrightNotice = ? , headline = ? where p.name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateIPTC)) {
            // Update IPTC
            preparedStatement.setString(1, iptcModel.getKeywords());
            preparedStatement.setString(2, iptcModel.getCopyrightNotice());
            preparedStatement.setString(3, iptcModel.getHeadline());
            preparedStatement.setString(4, picture.getFileName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }
        /*
        String updatePHOTOGRAPHER = "update PHOTOGRAPHER set FORENAME = ?, NAME = ?, BIRTH = ?, NOTE = ? where picture.name = '?'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updatePHOTOGRAPHER)) {
            // Update PHOTOGRAPHER
            preparedStatement.setString(1, pg.getFirstName());
            preparedStatement.setString(2, pg.getLastName());
            preparedStatement.setDate(3, Date.valueOf(pg.getBirthday()));
            preparedStatement.setString(4, pg.getNotes());
            preparedStatement.setString(5, pic.getFilename());
            preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }*/
    }


    @Override
    public void save(PictureModel picture) {
        String query = "****************************************************************************";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }
    }

    @Override
    public void deletePicture(int ID) {
        String query = "delete from picture where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }
    }

    @Override
    public Collection<PhotographerModel> getPhotographers() {
        String query = "select * from photographer";
        List<PhotographerModel> photographerList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PhotographerModel photographer = new PhotographerModelImpl();
                createPhotographer(resultSet, photographer);
                photographerList.add(photographer);
            }
        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }
        return photographerList;
    }

    @Override
    public PhotographerModel getPhotographer(int ID) {
        String query = "select * from photographer where id = ?";
        PhotographerModel photographer = new PhotographerModelImpl();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            createPhotographer(resultSet, photographer);
        } catch (SQLException e) {
            logger.error("SQLException getPhotographer: " + e.toString());
        }
        return photographer;
    }

    @Override
    public void save(PhotographerModel photographer) {
        String query = "INSERT INTO photographer(FIRSTNAME, LASTNAME, NOTES, BIRTHDATE) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, photographer.getFirstName());
            preparedStatement.setString(2, photographer.getLastName());
            preparedStatement.setString(3, photographer.getNotes());
            if (photographer.getBirthDay() != null) {
                preparedStatement.setDate(3, Date.valueOf(photographer.getBirthDay()));
            } else {
                preparedStatement.setDate(3, null);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }
    }

    @Override
    public void deletePhotographer(int ID) {
        String query = "delete from photographer where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException: " + e.toString());
        }
    }

    @Override
    public void updatePhotographer(PhotographerModel photographer, int index) {
        String query = "update photographer set firstname = ?, lastname = ?, birthdate = ?, notes = ? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, photographer.getFirstName());
            preparedStatement.setString(2, photographer.getLastName());
            preparedStatement.setDate(3, Date.valueOf(photographer.getBirthDay()));
            preparedStatement.setString(4, photographer.getNotes());
            preparedStatement.setInt(5, index);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException updatePhotographer: " + e.toString());
        }
    }

    @Override
    public void changePhotographer(PictureModel pictureModel, PhotographerModel photographerModel) {
        String getID = "select id from photographer where lastname = ?";
        String updatePhotographer = "update picture set fk_photographer = ? where name = ?";
        int id = 1;

        try (PreparedStatement preparedStatement = connection.prepareStatement(getID)) {
            preparedStatement.setString(1, photographerModel.getLastName());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt("id");

        } catch (SQLException e) {
            logger.error("SQLException updatePhotographer: " + e.toString());
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(updatePhotographer)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, pictureModel.getFileName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQLException updatePhotographer: " + e.toString());
        }
    }

    @Override
    public Set<String> getDistinctKeyword() {
        Set<String> keywords = new HashSet<>();
        String query = "select distinct keywords from iptc JOIN picture p on iptc.fk_picture_id = p.id";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                keywords.add(resultSet.getString("keywords"));
            }
        } catch (SQLException e) {
            logger.error("SQLException updatePhotographer: " + e.toString());
        }
        return keywords;
    }

    @Override
    public int getKeywordsCount(String keyword) {
        int count = 0;
        String query = "select count(*) as COUNT from picture JOIN iptc i on picture.id = i.fk_picture_id where i.keywords = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, keyword);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            count = resultSet.getInt("COUNT");
        } catch (SQLException e) {
            logger.error("SQLException updatePhotographer: " + e.toString());
        }
        return count;
    }

    private void createPhotographer(ResultSet resultSet, PhotographerModel photographer) throws SQLException {
        photographer.setID(resultSet.getInt("id"));
        photographer.setFirstName(resultSet.getString("firstname"));
        photographer.setLastName(resultSet.getString("lastname"));

        Date birthday = resultSet.getDate("birthdate");
        if (birthday != null) {
            LocalDate localDate = birthday.toLocalDate();
            photographer.setBirthDay(localDate);
        } else {
            photographer.setBirthDay(null);
        }

        photographer.setNotes(resultSet.getString("notes"));
    }

}
