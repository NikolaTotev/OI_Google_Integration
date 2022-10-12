package com.ocado.bootcamp.server.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException  {
        System.out.println("Redirecting to http://localhost:3000");
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
        System.out.println("Session cookie is:");
        System.out.println(details.getSessionId());

        Cookie cookie = new Cookie("sessionId", "LE_COOKIE");
        response.addCookie(cookie);
        response.setHeader("COOKIE", "LE_COOKIE");

        response.sendRedirect("http://localhost:3000");

//
//        authentication.getCredentials();
//        response.setHeader("Location", "localhost:3000");
//        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
//        Cookie cookie = new Cookie("sessionId", "LE_COOKIE");
//        response.addCookie(cookie);

    }
}