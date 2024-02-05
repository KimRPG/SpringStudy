package com.pard.oauth2.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/v1/login")
    public String loginP() {

        return "/v1/login";
    }
}