    package org.example.feignClient;


    import lombok.AllArgsConstructor;
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.Map;

    @RestController
    @RequiredArgsConstructor
    public class UserController {
        private final UserClient userClient;

        @GetMapping("/hi")
        public Map<String, Object> feign() {
            return userClient.getUser("nat=us");
        }
    }
