package com.chiragji.docuconverter.logic;

import com.chiragji.docuconverter.api.DocuConverter;
import com.chiragji.docuconverter.enums.PageSize;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;

/**
 * This class contains the common methods used by the implementors
 *
 * @author Chirag Gupta (chirag-ji)
 */
public abstract class AbstractDocuConverter implements DocuConverter, AutoCloseable {

    protected final InputStream inputStream;
    protected OutputStream outputStream;
    private boolean verbose;
    private boolean autoClose;
    protected PageSize pageSize = PageSize.A4;

    protected AbstractDocuConverter(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "InputStream is null");
        this.inputStream = inputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = Objects.requireNonNull(outputStream, "OutputStream is null");
    }

    @Override
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public boolean isVerbose() {
        return verbose;
    }

    protected void onStart() {
        log("Loading File", Level.INFO);
    }

    protected void onProcessing() {
        log("Processing file", Level.INFO);
    }

    protected void onCompleted() {
        log("File processed", Level.INFO);
        if (this.autoClose) {
            try {
                close();
            } catch (Exception e) {
                //ignore, no exception might occur here
            }
        }
    }

    protected void log(String message, Level level) {
        if (isVerbose())
            System.out.println(level + ": " + new Date() + ": " + message);
    }

    public void setAutoCloseResourceOnComplete(boolean autoClose) {
        this.autoClose = autoClose;
    }

    public boolean isAutoCloseResourceOnComplete() {
        return autoClose;
    }

    @Override
    public void setPageSize(PageSize pageSize) {
        this.pageSize = Objects.requireNonNull(pageSize, "PageSize is undefined");
    }

    @Override
    public void close() throws Exception {
        this.inputStream.close();
        this.outputStream.flush();
        this.outputStream.close();
    }
}
