package com.shorten.shortening.restContoller;

import java.util.HashMap;

import com.shorten.shortening.model.response.error.Error;
import com.shorten.shortening.model.response.error.ErrorsResponse;
import com.shorten.shortening.model.response.shortening.ShorteningResponse;
import com.shorten.shortening.service.UrlService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    final String urlRegex = "^(https|http)?://(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)$";
   
    UrlService urlService;

    public MainRestController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/convertUrl")
    @ResponseBody
    public ResponseEntity<?> postMain(@RequestBody HashMap<String, String> param) {
        System.out.println(param.toString());
        String originUrl;
        if(!param.containsKey("originUrl")){
            Error error = new Error("40010", "originUrl", "Please Check Url");
            return ResponseEntity.ok(new ErrorsResponse(400, "Bad Request", error));
        }else{
            originUrl = param.get("originUrl");
            if(!originUrl.matches(urlRegex)){
                Error error = new Error("40011", "originUrl", "Please Check Url");
                return ResponseEntity.ok(new ErrorsResponse(400, "Bad Request", error));
            }
        }
        
        String shorteningUrl = urlService.setShortening(originUrl);

        // 같은 URL 이 있는지 검색
        return ResponseEntity.ok(new ShorteningResponse(200, "Success", shorteningUrl));
    }
}