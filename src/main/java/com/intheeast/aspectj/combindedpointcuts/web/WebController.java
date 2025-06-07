package com.intheeast.aspectj.combindedpointcuts.web;

import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    public void handleRequest() {
        System.out.println("Handling web request");
    }
}