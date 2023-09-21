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
@RequestMapping("/v1")
public class CrawlingController {

    @Value("${crawling.url}")
    private List<String> urlList = new ArrayList<>();

    @Value("${https://www.google.com/search?q=}")
    private String googleSearchUrl;

    @Value("${naver.search.url}")
    private String naverSearchUrl;

    @Value("${binance.news.url}")
    private String binanceNewsUrl;

    @Value("${mk.search.url}")
    private String mkSearchUrl;

    @Value("${mk.category.url}")
    private String mkCategoryUrl;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/g")
    private String googleCrawing(@RequestParam(value = "query", required = false) String query) throws IOException {


        logger.debug("get query -> {}", query);
        logger.debug("get query -> {}", googleSearchUrl + query);
        Document doc = new Document(null);
        if(query == null){
            doc = Jsoup.connect("https:" + googleSearchUrl).get();
        }else {
            doc = Jsoup.connect("https:" + googleSearchUrl + query).get();
        }
        return doc.toString();
    }

    @GetMapping("/n")
    private String naverCrawing(@RequestParam(value = "query", required = false) String query) throws IOException {


        logger.debug("get query -> {}", query);
        logger.debug("get query -> {}", googleSearchUrl + query);
        Document doc = new Document(null);
        if(query == null){
            doc = Jsoup.connect("https:" + googleSearchUrl).get();
        }else {
            doc = Jsoup.connect("https:" + googleSearchUrl + query).get();
        }
        return doc.toString();
    }



    @GetMapping("/m")
    private String mkCrawing(@RequestParam(value = "query", required = false) String query) throws IOException {
        logger.debug("get query -> {}", query);
        logger.debug("get query -> {}", googleSearchUrl + query);
        Document doc = new Document(null);
        if(query == null){
            doc = Jsoup.connect("https:" + googleSearchUrl).get();
        }else {
            doc = Jsoup.connect("https:" + googleSearchUrl + query).get();
        }
        return doc.toString();
    }

    @GetMapping("/b")
    private String binanceCrawing(@RequestParam(value = "query", required = false) String query) throws IOException {


        logger.debug("get query -> {}", query);
        Document doc = new Document(null);
        if(query == null){
            doc = Jsoup.connect("https:" + googleSearchUrl).get();
        }else {
            doc = Jsoup.connect("https:" + googleSearchUrl + query).get();
        }
        return doc.toString();
    }


}
