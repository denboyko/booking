package com.botscrew.models.apiai;

/**
 * @author Den Boyko
 * @version 1.0
 */
public class Status {

    private Integer code;

    private String errorType;

    private String errorDetails;

    public Status() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }
}
