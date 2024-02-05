package com.pard.oauth2.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/v1/main")
    public String Main() {
        return "/v1/main";
    }
}
