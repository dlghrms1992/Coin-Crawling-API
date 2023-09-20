package com.coin.api.controller;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
            logger.debug("test => {}", urlList.get(0));

            String googleUrl = urlList.get(0);

            Document doc = Jsoup.connect(googleUrl).get();

            logger.debug("getData -> {}", doc.toString());
            return doc.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        }
    }

}
