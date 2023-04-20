package org.cbo.apiservlet.webapp.headers.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceCookieImp implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies() != null ? request.getCookies() : new Cookie[0];
        return Arrays.stream(cookies)
                .filter(c->"username".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
