package org.ericghara;

public class NoMorePermutationsException extends RuntimeException {

    public NoMorePermutationsException() {
        super();
    }

    public NoMorePermutationsException(String message) {
        super(message);
    }

    public NoMorePermutationsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMorePermutationsException(Throwable cause) {
        super(cause);
    }

    protected NoMorePermutationsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
