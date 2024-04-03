package org.example.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "riot", url = "")
public interface RiotClient {
}
