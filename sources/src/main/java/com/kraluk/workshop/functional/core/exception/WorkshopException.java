package com.kraluk.workshop.functional.core.exception;

/**
 * General Workshop RuntimeException
 *
 * @author lukasz
 */
public class WorkshopException extends RuntimeException {

    public WorkshopException() {
    }

    public WorkshopException(String message) {
        super(message);
    }

    public WorkshopException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkshopException(Throwable cause) {
        super(cause);
    }

    public WorkshopException(String message, Throwable cause, boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}