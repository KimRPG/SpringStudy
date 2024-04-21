package org.example.feignClient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "userClient", url = "https://randomuser.me/")
//@Qualifier("userClient")
public interface UserClient {
    @GetMapping(value = "/api/")
//<========== 함수 호출시 https://randomuser.me/api/가 되도록 설정
    Map<String, Object> getUser(@RequestParam("nat") String nation);
}
