package com.pard.externalapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pard.externalapi.dto.KakaoDTO;
import com.pard.externalapi.properties.KakaoProperties;
import com.pard.externalapi.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;
//
//    @GetMapping("/test")
//    public KakaoProperties test(){
//        return kakaoProperties;
//    }

    @GetMapping("/search")
    public KakaoDTO search(@RequestParam String query) throws JsonProcessingException {
        return kakaoService.search(query);
    }
    @GetMapping("/string")
    public String string(@RequestParam String query) throws JsonProcessingException {
        return kakaoService.searchString(query);
    }
}
