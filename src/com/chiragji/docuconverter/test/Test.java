package com.chiragji.docuconverter.test;

import com.chiragji.docuconverter.api.ConvertToType;
import com.chiragji.docuconverter.api.DocuConverter;
import com.chiragji.docuconverter.api.DocumentType;
import com.chiragji.docuconverter.logic.AbstractDocuConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Test class that shows the demonstration of the DocuConverter API
 *
 * @author Chirag Gupta (chirag-ji)
 */
public class Test {
    /**
     * Demonstration of conversion from {@link DocumentType#DOCX} to {@link ConvertToType#PDF}
     */
    public void docXToPdf() {
        try {
            File inFile = new File("test/test.docx");
            File outFile = new File("test/testDocX.pdf");
            DocuConverter docuConverter = DocuConverter.getConverter(new FileInputStream(inFile),
                    DocumentType.DOCX, ConvertToType.PDF);
            ((AbstractDocuConverter) docuConverter).setDebug(true); //optional
            docuConverter.convertIn(new FileOutputStream(outFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Demonstration of conversion from {@link DocumentType#PPTX} to {@link ConvertToType#PDF}
     */
    public void pptXToPdf() {
        try {
            File inFile = new File("test/test.pptx");
            File outFile = new File("test/testPptX.pdf");
            DocuConverter docuConverter = DocuConverter.getConverter(new FileInputStream(inFile),
                    DocumentType.PPTX, ConvertToType.PDF);
            ((AbstractDocuConverter) docuConverter).setDebug(true); //optional
            docuConverter.convertIn(new FileOutputStream(outFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Demonstration of conversion from {@link DocumentType#DOC} to {@link ConvertToType#PDF}
     */
    public void docToPdf() {
        try {
            File inFile = new File("test/test.doc");
            File outFile = new File("test/testDoc.pdf");
            DocuConverter docuConverter = DocuConverter.getConverter(new FileInputStream(inFile),
                    DocumentType.DOC, ConvertToType.PDF);
            ((AbstractDocuConverter) docuConverter).setDebug(true); //optional
            docuConverter.convertIn(new FileOutputStream(outFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

