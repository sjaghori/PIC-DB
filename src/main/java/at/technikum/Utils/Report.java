package at.technikum.Utils;

import at.technikum.Model.PictureModelImpl;
import at.technikum.interfaces.models.PictureModel;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;

public class Report {

    private static final Logger logger = LogManager.getLogger(Report.class);

    PictureModel pictureModel;
    String reportFilename;
    String imageFileName;
    String photographerName;
    String imagePath;

    public Report() {
        this("Report.pdf", new PictureModelImpl(1, "parrot.jpg", ""));
    }

    /**
     * Creates a report pdf file with the images iptc and exif metadata as well as the photographers name
     *
     * @param reportFilename name of the output file e.g. Report.pdf
     * @param picture        an Instance of PictureModel
     * @see PictureModel
     */
    public Report(String reportFilename, PictureModel picture) {
        this.reportFilename = setFilename(reportFilename);
        this.imageFileName = picture.getFileName();
        this.photographerName = "Sasan Jaghori";
        this.pictureModel = picture;
    }

    /**
     * Creates a unique Output filename for image report
     *
     * @return filename     report filename
     */
    public String setFilename(String filename) {
        DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        return filename.split("[.]")[0] + timeStampPattern.format(java.time.LocalDateTime.now()) + ".pdf";
    }

    /**
     * Creates and structures actual pdf document
     *
     * @return void
     */
    public void createReport() {
        OutputStream dest = null;
        try {
            // Creating a PdfWriter
            dest = new FileOutputStream(reportFilename);
        } catch (IOException e) {
            logger.error("IOException: " + e.toString());
        }


        Document document;
        try {
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, dest);
            document.open();

            // Adding paragraphs to document
            Paragraph heading = new Paragraph(new Phrase(15f, "Reporting",
                    FontFactory.getFont(FontFactory.TIMES_BOLD, 22)));
            heading.setSpacingAfter(15f);
            document.add(heading);

            Paragraph paragraph1 = createParagraphTask();
            paragraph1.setSpacingAfter(440);
            document.add(paragraph1);

            String imageFile = getImagePath();

            Image image = null;
            try {
                image = Image.getInstance(imageFile);
            } catch (IOException e) {
                logger.error(String.format("Exception while instancing the image: %s", e.getMessage()));
            }
            assert image != null;
            image.scaleToFit(400f, 400f);
            float x = (PageSize.A4.getWidth() - image.getScaledWidth()) / 2;
            image.setAbsolutePosition(x, 330);
            document.add(image);

            PdfContentByte canvas = createCurrentPhotoName(writer);

            PdfPTable exifTable = createEXIF_Table();
            exifTable.setSpacingAfter(15f);
            document.add(exifTable);

            PdfPTable iptcTable = createIPTC_Table();
            document.add(iptcTable);

            createPhotographerText(canvas);
            // Closing the document
            document.close();
        } catch (DocumentException e) {
            logger.error(String.format("Exception while creating Document: %s", e.getMessage()));
        }

        try {
            Desktop.getDesktop().open(new File(reportFilename));
        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            logger.error(String.format("Could not open PDF Document. %s", e.getMessage()));
        }
    }

    /**
     * gets Absolute Path of Image
     *
     * @return
     */
    private String getImagePath() {
        return System.getProperty("user.dir") +
                System.getProperty("file.separator") + "images" +
                System.getProperty("file.separator") + imageFileName;
    }

    private PdfContentByte createCurrentPhotoName(PdfWriter writer) {
        // Image Name
        Phrase imageName = new Phrase(this.imageFileName, FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 12));
        PdfContentByte canvas = writer.getDirectContent();
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, imageName, 260, 315, 0);
        return canvas;
    }

    private void createPhotographerText(PdfContentByte canvas) {
        // Photograph
        Phrase photographName = new Phrase("made with <3 by " + pictureModel.getPhotographer().getLastName(),
                FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 15));
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, photographName, 150, 30, 0);
    }

    private PdfPTable createIPTC_Table() {
        // IPTC Table
        PdfPTable iptcTable = new PdfPTable(2);
        iptcTable.setSpacingBefore(20.0f);
        PdfPCell cell2 = new PdfPCell(new Paragraph(
                (new Phrase(3f, "IPTC", FontFactory.getFont(FontFactory.defaultEncoding, 14)))
        ));
        cell2.setColspan(4);
        iptcTable.addCell(cell2);
        iptcTable.addCell("keywords:");
        iptcTable.addCell(pictureModel.getIPTC().getKeywords());
        iptcTable.addCell("copyrightNotice:");
        iptcTable.addCell(pictureModel.getIPTC().getCopyrightNotice());
        iptcTable.addCell("headline:");
        iptcTable.addCell(pictureModel.getIPTC().getHeadline());
        iptcTable.setSpacingAfter(30f);
        return iptcTable;
    }

    private PdfPTable createEXIF_Table() {
        // EXIF Table
        PdfPTable exifTable = new PdfPTable(2);
        exifTable.setSpacingBefore(10.0f);
        PdfPCell cell = new PdfPCell(new Paragraph(
                new Phrase(3f, "EXIF", FontFactory.getFont(FontFactory.defaultEncoding, 14))
        ));
        cell.setColspan(4);
        exifTable.addCell(cell);
        exifTable.addCell("make:");
        exifTable.addCell(pictureModel.getEXIF().getMake());
        exifTable.addCell("fNumber:");
        exifTable.addCell(String.valueOf(pictureModel.getEXIF().getFNumber()));
        exifTable.addCell("exposureTime:");
        exifTable.addCell(String.valueOf(pictureModel.getEXIF().getExposureTime()));
        exifTable.addCell("isoValue:");
        exifTable.addCell(String.valueOf(pictureModel.getEXIF().getISOValue()));
        exifTable.addCell("flash:");
        exifTable.addCell(String.valueOf(pictureModel.getEXIF().getFlash()));
        exifTable.addCell("exposurePrograms:");
        exifTable.addCell(String.valueOf(pictureModel.getEXIF().getExposureProgram()));
        return exifTable;
    }

    private Paragraph createParagraphTask() {
        String aufgabenstellung = "Ein einzelnes Bild wird gedruckt. Es werden die IPTC sowie EXIF Informationen\n" +
                "gedruckt. Der oder die Fotograf_inn wird enfalls gedruckt.";
        return new Paragraph(aufgabenstellung);
    }
}