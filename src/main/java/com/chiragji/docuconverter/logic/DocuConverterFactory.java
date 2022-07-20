package com.chiragji.docuconverter.logic;

import com.chiragji.docuconverter.api.ConvertToType;
import com.chiragji.docuconverter.api.DocuConverter;
import com.chiragji.docuconverter.api.DocumentType;
import com.chiragji.docuconverter.exceptions.UnsupportedTypeException;

import java.io.InputStream;
import java.util.Objects;

/**
 * This class will generate the implementer according to parameters
 *
 * @author Chirag Gupta (chirag-ji)
 */
public interface DocuConverterFactory {
    /**
     * This will initiate the implementers of the {@link DocuConverter} to perform the related conversion
     *
     * @param inputStream The stream in which the source document exists
     * @param from        Type of source document
     * @param to          Type of designating document
     * @return The type implementor of the related conversion method
     * @throws UnsupportedTypeException if no implementation found for the documents
     */
    static DocuConverter getConverter(InputStream inputStream, DocumentType from, ConvertToType to)
            throws UnsupportedTypeException {
        Objects.requireNonNull(from, "DocumentType Type is null");
        Objects.requireNonNull(to, "ConvertTo type document to is null");
        if (to == ConvertToType.PDF) {
            switch (from) {
                case DOCX:
                    return new DocXtoPdf(inputStream);
                case PPTX:
                    return new PptXToPdf(inputStream);
                case TXT:
                    return new TextToPdf(inputStream);
                case PPT:
                    return new PptToPdf(inputStream);
            }
        } else if (to == ConvertToType.XML) {
            if (from == DocumentType.CSV) {
                return new CsvToXml(inputStream);
            }
        }
        throw new UnsupportedTypeException("Conversion from '" + from.name() + "' to '" + to.name() + "' is not currently supported");
    }
}
