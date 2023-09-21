package com.coin.api.controller;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/")
public class CrawlingController {

    @Value("${crawling.url}")
    private List<String> urlList = new ArrayList<>();

    @Value("${https://www.google.com/search?q=}")
    private String googleSearchUrl;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/g")
    private String googleCrawing(@RequestParam("query") String query) throws IOException {


        logger.debug("get query -> {}", query);
        Document doc = new Document(null);
        if(query == null){
            doc = Jsoup.connect(googleSearchUrl).get();
        }else {
            doc = Jsoup.connect(googleSearchUrl + query).get();
        }
        return doc.toString();
    }


}
