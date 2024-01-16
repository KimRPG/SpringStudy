package com.pard.externalapi.controller;

import com.pard.externalapi.properties.KakaoProperties;
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

    private final KakaoProperties kakaoProperties;

    @GetMapping("/test")
    public KakaoProperties test(){
        return kakaoProperties;
    }

    @GetMapping("/search")
    public String search(@RequestParam String query){
        Mono<String> mono = WebClient.builder().baseUrl("https://dapi.kakao.com")
                .build().get()
                .uri(builder -> builder.path("/v2/local/search/address.json")
                        .queryParam("query", query)
                        .build()
                )
                .header("Authorization", "KakaoAK " + kakaoProperties.getRestapi())
                .exchangeToMono(response -> {
                    return response.bodyToMono(String.class);
                });

        return mono.block();
    }
}
