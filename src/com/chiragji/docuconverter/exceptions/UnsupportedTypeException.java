package com.chiragji.docuconverter.exceptions;

/**
 * @author Chirag Gupta (chirag-ji)
 */
public class UnsupportedTypeException extends Exception {
    public UnsupportedTypeException() {
    }

    public UnsupportedTypeException(String message) {
        super(message);
    }

    public UnsupportedTypeException(Throwable cause) {
        super(cause);
    }
}
