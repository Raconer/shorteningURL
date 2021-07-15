package com.shorten.shortening.controller;

import com.shorten.shortening.service.UrlService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
   
    UrlService urlService;

    public MainController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String getMain() {
        return "main";
    }

    @GetMapping("/{path}")
    public String setShortening(@PathVariable("path") String path, Model model) {
        String originUrl = urlService.getUrl(path);
        model.addAttribute("originUrl", originUrl);
        return "redirect";
    } 
}
