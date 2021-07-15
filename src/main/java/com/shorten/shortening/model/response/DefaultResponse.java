package com.shorten.shortening.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultResponse {
    private Integer code;
    private String message;
    
    public DefaultResponse() {}
    public DefaultResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
