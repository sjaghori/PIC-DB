package at.technikum.Utils;

import at.technikum.Business.BusinessLayerImpl;
import at.technikum.interfaces.BusinessLayer;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Tags {

    private static final Logger logger = LogManager.getLogger(Tags.class);

    String tagsFilename;
    Set<String> keywordsSet;
    String[] nestedKeywords;
    BusinessLayer dal;

    public Tags() {
        this("Tags.pdf");
    }

    public Tags(String tagsFilename) {
        this.tagsFilename = setFilename(tagsFilename);
        dal = BusinessLayerImpl.getInstance();
    }


    /**
     * Creates a unique Output filename for tags report
     *
     * @return filename     report filename
     */
    public String setFilename(String filename) {
        DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        return filename.split("[.]")[0] + timeStampPattern.format(java.time.LocalDateTime.now()) + ".pdf";
    }

    public void createTag() {
        OutputStream dest = null;
        try {
            // Creating a PdfWriter
            dest = new FileOutputStream(this.tagsFilename);
        } catch (IOException e) {
            logger.error("IOException: " + e.toString());
        }

        Document document;
        try {
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, dest);
            document.open();

            // Adding paragraphs to document
            Paragraph heading = new Paragraph(new Phrase(15f, "Tagging",
                    FontFactory.getFont(FontFactory.TIMES_BOLD, 22)));
            heading.setSpacingAfter(15f);
            document.add(heading);

            keywordsSet = dal.getDistinctKeyword();
            PdfPTable keywordTable = new PdfPTable(2);
            PdfPCell cellkeyword = new PdfPCell(new Paragraph(
                    new Phrase(3f, "Keyword", FontFactory.getFont(FontFactory.defaultEncoding, 14))));
            PdfPCell cellcount = new PdfPCell(new Paragraph(
                    new Phrase(3f, "COUNT", FontFactory.getFont(FontFactory.defaultEncoding, 14))));
            keywordTable.addCell(cellkeyword);
            keywordTable.addCell(cellcount);
            keywordTable.setSpacingBefore(30.0f);
            for (String keyword : keywordsSet) {
                if (keyword.indexOf(',') != -1) {
                    nestedKeywords = keyword.split((", "));
                    for (String keyword2 : nestedKeywords) {
                        System.out.println(keyword2);
                        keywordTable.addCell(keyword2);
                        keywordTable.addCell(String.valueOf(dal.getKeywordsCount(keyword)));
                    }
                } else {
                    System.out.println(keyword);
                    keywordTable.addCell(keyword);
                    keywordTable.addCell(String.valueOf(dal.getKeywordsCount(keyword)));
                }
            }
            keywordTable.setSpacingAfter(20.0f);
            document.add(keywordTable);

            // Closing the document
            document.close();
        } catch (DocumentException e) {
            logger.error(String.format("Exception while creating Document: %s", e.getMessage()));
        }

        try {
            Desktop.getDesktop().open(new File(tagsFilename));
        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            logger.error(String.format("Could not open PDF Document. %s", e.getMessage()));
        }

    }


}
