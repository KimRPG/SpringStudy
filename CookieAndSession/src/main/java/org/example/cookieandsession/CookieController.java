package org.example.cookieandsession;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {

    @GetMapping("/cookie") //cookie 설정
    public void setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("user", "hs"); // Name-Value로 쿠키를 만듦
        cookie.setPath("/"); //
        //cookie.setSecure(true); //https 사용한다면 켜주세요
        cookie.setAttribute("SameSite", "Lax"); //이거는 나중에 설명
        cookie.setMaxAge(30*60); //이거는 몇 초동안 쿠키를 유지할 것인지
        cookie.setHttpOnly(true); // JavaScript에서 쿠키에 접근할 수 없도록 함
        response.addCookie(cookie);
    }

    @GetMapping("/get_cookie")
    public String getCookie(@CookieValue String user) {
        return user;
    }

    @PostMapping("/delete_cookie")
    public void deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0); // 쿠키의 expiration 타임을 0으로 하여 없앤다.
        cookie.setPath("/"); // 모든 경로에서 삭제 됬음을 알린다.
        response.addCookie(cookie);
    }

    @PostMapping("/session")
    public String createSession(HttpServletRequest req) {
        // 세션이 존재할 경우 세션 반환, 없을 경우 새로운 세션을 생성한 후 반환
        HttpSession session = req.getSession(true);

        // 세션에 저장될 정보 Name - Value 를 추가합니다.
        session.setAttribute("session", "하이 세션");
        session.setAttribute("gkdl", "qkdl session");
        return "createSession";
    }

    @GetMapping("/get_session")
    public String getSession(HttpSession session) {
        // 세션이 존재할 경우 세션 반환, 없을 경우 null 반환

        String value = (String) session.getAttribute("session"); // 가져온 세션에 저장된 Value 를 Name 을 사용하여 가져옵니다.
        String value2 = (String) session.getAttribute("gkdl");
        System.out.println("value = " + value);
        System.out.println("value = " + value2);

        return "getSession : " + value + value2;
    }

    @PostMapping("/delete_session")
    public String deleteSession(HttpServletRequest req) {
        // 세션이 존재할 경우 세션 반환, 없을 경우 새로운 세션을 생성한 후 반환
        HttpSession session = req.getSession(true);

        session.removeAttribute("session");

        return "createSession";
    }
}
