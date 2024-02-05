package com.pard.oauth2.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/v1/admin")
    public String admin() {
        return "/v1/admin";
    }
}
