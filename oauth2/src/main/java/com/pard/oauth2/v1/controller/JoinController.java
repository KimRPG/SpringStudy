package com.pard.oauth2.v1.controller;

import com.pard.oauth2.v1.dto.JoinDTO;
import com.pard.oauth2.v1.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @GetMapping("/v1/join")
    public String joinP() {
        return "v1/join";
    }

    @PostMapping("/v1/joinProc")
    private String joinProcess(JoinDTO dto) {
        System.out.println(dto);
        joinService.joinProcess(dto);
        return "redirect:/v1/login";
    }
}
