package com.shorten.shortening.model.response.error;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Error {
    private String errorCode;
    private String field;
    private String message;

    public Error(String errorCode, String field, String message) {
        this.errorCode = errorCode;
        this.field = field;
        this.message = message;
    }
}
