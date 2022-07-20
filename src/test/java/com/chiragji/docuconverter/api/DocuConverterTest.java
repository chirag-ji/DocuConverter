package com.chiragji.docuconverter.api;

import com.chiragji.docuconverter.AbstractTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.nio.file.Files;

@Testable
@ExtendWith(MockitoExtension.class)
class DocuConverterTest extends AbstractTest {

    @Test
    void txtToPdf() throws Exception {
        File inFile = getTestInFile("test.txt");
        File outFile = getTestOutFile("testTxt.pdf");
        DocuConverter docuConverter = DocuConverter.getConverter(Files.newInputStream(inFile.toPath()),
                DocumentType.TXT, ConvertToType.PDF);
        docuConverter.setVerbose(true); //optional
        docuConverter.convertIn(Files.newOutputStream(outFile.toPath()));
        assertFileExists(outFile);
    }

    //    @Test
    void docXToPdf() throws Exception {
        File inFile = getTestInFile("test.docx");
        File outFile = getTestOutFile("testDocx.pdf");
        DocuConverter docuConverter = DocuConverter.getConverter(Files.newInputStream(inFile.toPath()),
                DocumentType.DOCX, ConvertToType.PDF);
        docuConverter.setVerbose(true); //optional
        docuConverter.convertIn(Files.newOutputStream(outFile.toPath()));
        assertFileExists(outFile);
    }

    @Test
    void pptToPdf() throws Exception {
        File inFile = getTestInFile("test.ppt");
        File outFile = getTestOutFile("testPpt.pdf");
        DocuConverter docuConverter = DocuConverter.getConverter(Files.newInputStream(inFile.toPath()),
                DocumentType.PPT, ConvertToType.PDF);
        docuConverter.setVerbose(true); //optional
        docuConverter.convertIn(Files.newOutputStream(outFile.toPath()));
        assertFileExists(outFile);
    }

    @Test
    void pptXToPdf() throws Exception {
        File inFile = getTestInFile("test.pptx");
        File outFile = getTestOutFile("testPptx.pdf");
        DocuConverter docuConverter = DocuConverter.getConverter(Files.newInputStream(inFile.toPath()),
                DocumentType.PPTX, ConvertToType.PDF);
        docuConverter.setVerbose(true); //optional
        docuConverter.convertIn(Files.newOutputStream(outFile.toPath()));
        assertFileExists(outFile);
    }

    @Test
    void csvToXml() throws Exception {
        File inFile = getTestInFile("test.csv");
        File outFile = getTestOutFile("testCsv.xml");
        DocuConverter docuConverter = DocuConverter.getConverter(Files.newInputStream(inFile.toPath()),
                DocumentType.CSV, ConvertToType.XML);
        docuConverter.setVerbose(true); //optional
        docuConverter.convertIn(Files.newOutputStream(outFile.toPath()));
        assertFileExists(outFile);
    }
}