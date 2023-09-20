package com.coin.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {


    @GetMapping("")
    public String test(){

        return "test";
    }
}
