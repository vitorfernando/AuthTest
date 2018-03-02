package com.example.controllers;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class HomeController {

    @RequestMapping({"/user", "/me"})
    public Object user(OAuth2Authentication principal) {
        Map<String, Object> principalMap = new LinkedHashMap<>();

        principalMap.put("tokenValue", ((OAuth2AuthenticationDetails) principal.getDetails()).getTokenValue());
        principalMap.put("tokenType", ((OAuth2AuthenticationDetails) principal.getDetails()).getTokenType());
        principalMap.put("principal", principal.getName());
        principalMap.put("name", principal.getName());
        
        return principalMap;
    }

    @RequestMapping("/usuario")
    public Object usuario(OAuth2Authentication principal) {
        return principal;
    }

}
