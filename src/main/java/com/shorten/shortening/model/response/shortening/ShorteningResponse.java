package com.shorten.shortening.model.response.shortening;

import com.shorten.shortening.model.response.DefaultResponse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShorteningResponse extends DefaultResponse{
    String shorteningUrl;
    public ShorteningResponse(Integer code, String message, String shorteningUrl){
        super(code, message);
        this.shorteningUrl = shorteningUrl;
    }
}
