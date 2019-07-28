package com.chiragji.docuconverter.logic;

import com.chiragji.docuconverter.enums.FontStyle;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Objects;

/**
 * @author Chirag Gupta (chirag-ji)
 */
public final class TextToPdf extends AbstractDocuConverter {
    private FontStyle fontStyle = FontStyle.NORMAL;
    private int fontSize = 11;

    TextToPdf(InputStream inputStream) {
        super(inputStream);
    }

    public void setFontSize(int fontSize) {
        if (fontSize <= 0)
            throw new IllegalArgumentException("Invalid font size: " + fontSize);
        this.fontSize = fontSize;
    }

    public void setFontStyle(FontStyle fontStyle) {
        this.fontStyle = Objects.requireNonNull(fontStyle, "Font style is undefined");
    }

    @Override
    public void convertIn(OutputStream outputStream) throws Exception {
        setOutputStream(outputStream);
        onStart();
        Document document = new Document(pageSize.getPageDimension());
        PdfWriter.getInstance(document, this.outputStream).setPdfVersion(PdfWriter.PDF_VERSION_1_7);
        document.open();
        onProcessing();
        Font font = new Font();
        font.setStyle(this.fontStyle.getStyle());
        font.setSize(this.fontSize);
        document.add(new Paragraph("\n"));
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Paragraph para = new Paragraph(line + "\n", font);
                para.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(para);
            }
        }
        document.close();
        onCompleted();
    }
}
