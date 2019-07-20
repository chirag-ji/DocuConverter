package com.chiragji.docuconverter.api;

import com.chiragji.docuconverter.exceptions.UnsupportedTypeException;
import com.chiragji.docuconverter.logic.DocXtoPdf;
import com.chiragji.docuconverter.logic.PptXToPdf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/**
 * API for converting Document from one from to another format
 *
 * @author Chirag Gupta (chirag-ji)
 * @see com.chiragji.docuconverter.logic.AbstractDocuConverter
 * @see com.chiragji.docuconverter.test.Test
 */
public interface DocuConverter {

    /**
     * This will start the conversion of the document
     *
     * @param outputStream The stream to which the converted document will be hold on
     * @throws Exception if any error occur in the document conversion
     */
    void convertIn(OutputStream outputStream) throws Exception;

    /**
     * This will initiate the implementers of the {@link DocuConverter} to perform the related conversion
     *
     * @param inputStream The stream in which the source document exists
     * @param from        Type of source document
     * @param to          Type of designating document
     * @return The type implementor of the related conversion method
     * @throws Exception                any error in conversion
     * @throws UnsupportedTypeException if no implementation found for the documents
     */
    static DocuConverter getConverter(InputStream inputStream, DocumentType from, ConvertToType to) throws Exception {
        Objects.requireNonNull(from, "DocumentType Type is null");
        Objects.requireNonNull(to, "ConverTo type document to is null");
        System.out.println("from = " + from + ", to = " + to);
        if (to == ConvertToType.PDF) {
            if (from == DocumentType.DOCX)
                return new DocXtoPdf(inputStream);
            else if (from == DocumentType.PPTX)
                return new PptXToPdf(inputStream);
//            else if (from == DocumentType.DOC)
//                return new DocToPdf(inputStream);
        }
        throw new UnsupportedTypeException("Conversion from '" + from.name() + "' to '" + to.name() + "' is not currently supported");
    }
}
