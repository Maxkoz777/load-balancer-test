package com.example.loadbalancertest.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class PageTester {

    private final WebClient webClient;

    public Mono<String> getUserByIdAsync() {
        return webClient
            .get()
            .retrieve()
            .bodyToMono(String.class);
    }

    public int getInstanceNumber(String page) {
        int index = page.indexOf("Instance");
        char charCode = page.charAt(index + 9);
//        log.info("instance number: {}", charCode);
        return Character.getNumericValue(charCode) - 1;
    }

}
