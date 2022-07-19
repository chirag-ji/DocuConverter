package com.chiragji.docuconverter.logic;

import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Chirag Gupta (chirag-ji)
 */
public final class PptToPdf extends AbstractDocuConverter {
    private List<HSLFSlide> slides;
    private Dimension size;
    private int zoomLevel = 2;

    public void setZoomLevel(int zoomLevel) {
        if (zoomLevel <= 0)
            throw new IllegalArgumentException("Invalid zoo level: " + zoomLevel +
                    ", A non zero positive number is only acceptable");
        this.zoomLevel = zoomLevel;
    }

    PptToPdf(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void convertIn(OutputStream outputStream) throws Exception {
        setOutputStream(outputStream);
        onStart();
        init();
        ensureSlides();
        onProcessing();
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToScale(zoomLevel, zoomLevel);
        Document document = new Document(this.pageSize.getPageDimension());
        PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
        document.open();
        int width = (int) Math.ceil(this.size.width * zoomLevel), height = (int) Math.ceil(this.size.height * zoomLevel);
        for (HSLFSlide slide : slides) {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.setTransform(affineTransform);
            g.setPaint(getBackgroundColor(slide));
            g.fill(new Rectangle2D.Float(0, 0, this.size.width, this.size.height));
            try {
                slide.draw(g);
            } catch (Exception e) {
                // ignore
            }
            com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(image, null);
            document.setPageSize(new Rectangle(img.getScaledWidth(), img.getScaledHeight()));
            document.newPage();
            img.setAbsolutePosition(0, 0);
            document.add(img);
        }
        document.close();
        pdfWriter.close();
        onCompleted();
    }

    private void ensureSlides() {
        if (slides == null || slides.isEmpty())
            throw new IllegalArgumentException("Invalid file to convert to pdf from pptx. No slides found");
    }

    private void init() throws IOException {
        HSLFSlideShow slideShow = new HSLFSlideShow(this.inputStream);
        this.size = slideShow.getPageSize();
        slides = slideShow.getSlides();
    }

    private Color getBackgroundColor(HSLFSlide hslfSlide) {
        return hslfSlide.getBackground().getFill().getForegroundColor();
    }
}
