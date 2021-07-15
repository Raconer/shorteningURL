package com.shorten.shortening.model.shortening;

import java.math.BigInteger;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Shortening {
    private BigInteger idx;
    private String originUrl;
    private String shorteningUrl;
    private Date regDate;   


    public Shortening() {}

    public Shortening(String originUrl, Date regDate) {
        this.originUrl = originUrl;
        this.regDate = regDate;
    }

}