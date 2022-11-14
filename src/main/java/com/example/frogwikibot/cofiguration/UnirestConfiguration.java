package com.example.frogwikibot.cofiguration;

import kong.unirest.Unirest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnirestConfiguration {

    @Bean
    public void unirestConfig() {
        Unirest.config()
                .followRedirects(false)
                .cookieSpec("ignoreCookies");
    }
}
