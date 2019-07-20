package com.chiragji.docuconverter.logic;

import com.chiragji.docuconverter.exceptions.DocuConverterException;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import fr.opensagres.poi.xwpf.converter.pdf.internal.PdfMapper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Objects;

/**
 * @author Chirag Gupta (chirag-ji)
 */
public abstract class PDFConverter {

    public static void convert(XWPFDocument xwpfDocument, OutputStream outputStream, PdfOptions pdfOptions)
            throws DocuConverterException {
        try {
            Objects.requireNonNull(xwpfDocument, "Type is null");
            Objects.requireNonNull(outputStream, "OutputStream is null");
            ByteArrayOutputStream temp = new ByteArrayOutputStream();
            PdfMapper mapper = new PdfMapper(xwpfDocument, temp, pdfOptions, null);
            mapper.start();
            if (mapper.useTotalPageField()) {
                int pageCount = mapper.getPageCount();
                mapper = new PdfMapper(xwpfDocument, outputStream, pdfOptions, pageCount);
                mapper.start();
            } else
                outputStream.write(temp.toByteArray());
        } catch (Exception e) {
            throw new DocuConverterException(e);
        }
    }

}
