package com.shorten.shortening.service;

import java.math.BigInteger;
import java.util.Date;

import com.shorten.shortening.model.shortening.Shortening;
import com.shorten.shortening.repository.UrlMapper;
import com.shorten.shortening.util.Base62Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    
    @Value("${domain.url}")
    String domain;

    UrlMapper urlMapper;

    public UrlService(UrlMapper urlMapper) {
        this.urlMapper = urlMapper;
    }

    public String getUrl(String shorteningUrl){
        Shortening shortening = new Shortening();
        BigInteger idx = Base62Util.decoding(shorteningUrl);
        shortening.setIdx(idx);
        shortening = urlMapper.get(shortening);
        if(shortening != null){
            return shortening.getOriginUrl();
        }
        return null;
    }

    public String setShortening(String originUrl){ 

        Shortening shortening = new Shortening();
        shortening.setOriginUrl(originUrl);
        shortening = urlMapper.get(shortening);
        //  Max Index
        BigInteger checkIdx;
        String shorteningUrl;
               
        if(shortening != null){
            checkIdx = shortening.getIdx();
            shorteningUrl = Base62Util.encoding(checkIdx);
            return domain + shorteningUrl;
        }else{
            shortening = new Shortening(originUrl, new Date());
            urlMapper.insert(shortening);
            checkIdx = shortening.getIdx();
            BigInteger maxIdx = new BigInteger("218340105584895");
            
            if(maxIdx.compareTo(checkIdx) < 1){
                shorteningUrl = "";
            }else{
                shorteningUrl = Base62Util.encoding(checkIdx);
            }
            return domain + shorteningUrl;
        }
    }
}