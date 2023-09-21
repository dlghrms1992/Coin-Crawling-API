package com.coin.api.controller;


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
    public ResponseEntity test() {
        logger.debug("info");

        try {
            List<Map<String, Object>> urlData = new ArrayList<>();
            for(String url : urlList) {
                if(Jsoup.connect(url).execute().statusCode() == 200){
                    Document doc = Jsoup.connect(url).get();
                    Map<String, Object> data = new HashMap<>();
                    data.put(url, doc);
                    urlData.add(data);

                }else {
                    logger.error("해당 url -> {} 연결 못함", url);
                }
            }

            return new ResponseEntity(urlData,HttpStatus.ACCEPTED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_GATEWAY);
        }
    }

}
