package com.ocado.bootcamp.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLOutput;
import java.util.Map;

public class AuthEndpoints {
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/loginok")
    public ResponseEntity<String> getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService
                .loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());


        System.out.println("Reg id: ");
        System.out.println(authentication.getAuthorizedClientRegistrationId());

        String userInfoEndpointUri = client.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUri();

        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
                    .getTokenValue());
            HttpEntity entity = new HttpEntity("", headers);
            ResponseEntity<Map> response = restTemplate
                    .exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
            Map userAttributes = response.getBody();

            model.addAttribute("name", userAttributes.get("name"));
            model.addAttribute("email", userAttributes.get("email"));
        }

        return new ResponseEntity<String>( "Ooga Booga", HttpStatus.OK);
    }

    @RequestMapping(value = "/path", method = RequestMethod.GET)
    public void handleGet(HttpServletResponse response) {
        response.setHeader("Location", "localhost:3000/MainPage");
        response.setStatus(302);
    }
}
