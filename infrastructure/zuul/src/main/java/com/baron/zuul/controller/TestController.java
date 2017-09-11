package com.baron.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @GetMapping("/a")
    public String a() {
        RestTemplate restTemplate = new RestTemplate();
        String bWords = restTemplate.getForObject("http://zuul/b", String.class);
        return "a: this is a, b: " + bWords;
    }

    @GetMapping("/b")
    public String b() {
        return "this is b";
    }
}
