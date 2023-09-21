package com.coin.api.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

@RestController
public class CommonController {

    @Value("${crawling.url}")
    private List<String> urlList = new ArrayList<>();
    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("")
    public String test() {
        logger.debug("info");

        try {
            List<String> urlData = new ArrayList<>();
            for(String url : urlList) {
                if(Jsoup.connect(url).execute().statusCode() == 200){
                    Document doc = Jsoup.connect(url).get();

                    urlData.add(doc.toString());
                }else {
                    logger.error("해당 url -> {} 연결 못함", url);
                }
            }

            return urlData.get(3);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
