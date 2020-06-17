package at.technikum.PresentationModel;

import at.technikum.Model.PictureModelImpl;
import at.technikum.interfaces.models.PictureModel;
import at.technikum.interfaces.presentationmodels.*;

public class PicturePresentationModelImpl implements PicturePresentationModel {
    PictureModel pictureModel = new PictureModelImpl(1, "","");
    IPTCPresentationModel iptcPresentationModel = new IPTCPresentationModelImpl();
    EXIFPresentationModel exifPresentationModel = new EXIFPresentationModelImpl();
    //PhotographerPresentationModel photographerPresentationModel = new PhotographerPresentationModelImpl();

    // TODO: Bin mir da noch nicht sicher
    @Override
    public int getID() {
        return this.pictureModel.getID();
    }

    @Override
    public String getFileName() {
        return this.pictureModel.getFileName();
    }

    @Override
    public String getFilePath() {
        return this.pictureModel.getFileName();
    }

    @Override
    public String getDisplayName() {
        try {
            return this.pictureModel.getFileName().split(",")[0];
        } catch (IllegalStateException e) {
            return this.pictureModel.getFileName();
        }
    }

    @Override
    public IPTCPresentationModel getIPTC() {
        return this.iptcPresentationModel;
    }

    @Override
    public EXIFPresentationModel getEXIF() {
        return this.exifPresentationModel;
    }

    @Override
    public PhotographerPresentationModel getPhotographer() {
        //return this.photographerPresentationModel;
        return null;
    }
}
