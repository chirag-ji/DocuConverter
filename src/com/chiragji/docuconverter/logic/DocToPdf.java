package com.chiragji.docuconverter.logic;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Chirag Gupta (chirag-ji)
 */
final class DocToPdf extends AbstractDocuConverter {
    DocToPdf(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void convertIn(OutputStream outputStream) throws Exception {
        setOutputStream(outputStream);
        onStart();
        WordprocessingMLPackage aPackage = Docx4J.load(this.inputStream);
        onProcessing();
        Docx4J.toPDF(aPackage, outputStream);
        onCompleted();
    }
}
