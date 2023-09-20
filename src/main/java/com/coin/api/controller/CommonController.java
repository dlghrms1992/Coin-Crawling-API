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
//            String googleUrl = "https://www.google.com/search?newwindow=1&sca_esv=566763369&sxsrf=AM9HkKm7rRfV3RyNmzjKUdP7WpT6Bq1tHg:1695173126554&q=%EB%B9%84%ED%8A%B8%EC%BD%94%EC%9D%B8&tbm=nws&source=lnms&sa=X&ved=2ahUKEwihyqmAhLiBAxULhVYBHX02B58Q0pQJegQIChAB&biw=2133&bih=1025&dpr=0.9";

            Document doc = Jsoup.connect(googleUrl).get();

            logger.debug("getData -> {}", doc.toString());
            return doc.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage().toString();
        }
    }

}
