package com.coin.api.controller;


import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/")
public class CrawlingController {

    @Value("${crawling.url}")
    private List<String> urlList = new ArrayList<>();
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/g")
    private String googleCrawing(){

        Document doc = new Document(null);
        return "";
    }


}
