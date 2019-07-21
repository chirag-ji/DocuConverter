package com.chiragji.docuconverter.api;

import com.chiragji.docuconverter.enums.PageSize;
import com.chiragji.docuconverter.exceptions.UnsupportedTypeException;
import com.chiragji.docuconverter.logic.DocuConverterFactory;

import java.io.InputStream;
import java.io.OutputStream;

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
     * This will set the document size
     *
     * @param pageSize document size
     * @apiNote This is only effective in some conversions
     */
    void setPageSize(PageSize pageSize);

    /**
     * This will initiate the implementers of the {@link DocuConverter} to perform the related conversion
     *
     * @param inputStream The stream in which the source document exists
     * @param from        Type of source document
     * @param to          Type of designating document
     * @return The type implementor of the related conversion method
     * @throws UnsupportedTypeException if no implementation found for the documents
     * @see DocuConverterFactory#getConverter(InputStream, DocumentType, ConvertToType)
     */
    static DocuConverter getConverter(InputStream inputStream, DocumentType from, ConvertToType to)
            throws UnsupportedTypeException {
        return DocuConverterFactory.getConverter(inputStream, from, to);
    }
}
