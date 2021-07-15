package com.shorten.shortening.model.response.error;

import java.util.ArrayList;
import java.util.List;

import com.shorten.shortening.model.response.DefaultResponse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorsResponse extends DefaultResponse{
    private List<Error> errorList;

    public ErrorsResponse(Integer code, String message){
        super(code, message);
    }

    public ErrorsResponse(Integer code, String message, Error error){
        super(code, message);
        List<Error> errorList = new ArrayList<>();
        errorList.add(error);
        this.errorList = errorList;
    }

    public ErrorsResponse(Integer code, String message, List<Error> errorList){
        super(code, message);
        this.errorList = errorList;
    }
}
