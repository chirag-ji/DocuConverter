package com.chiragji.docuconverter.logic;

import org.apache.poi.hslf.record.Slide;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Chirag Gupta (chirag-ji)
 */
final class PptToPdf extends AbstractDocuConverter {
    private List<Slide> slides;

    PptToPdf(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void convertIn(OutputStream outputStream) throws Exception {

    }

    private void init() {

    }
}
