package com.fss.hystriximpl.constants;

public final class ErrorConstants {
    public static final String RESPONSE_CODE = "00";
    public static final String RESPONSE_MESSSAGE = "SUCCESS";
    /**
     * Constants class should not be instantiated.
     */
    private ErrorConstants() {
        throw new IllegalStateException("Error Constant class");
    }

}
