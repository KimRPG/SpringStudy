package com.pard.externalapi.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties
public class KakaoProperties {
    private String restapi;
    private String javascript;
    private String clientSecret;
}
