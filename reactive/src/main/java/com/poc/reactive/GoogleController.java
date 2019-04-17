package com.poc.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GoogleController {

    private final GoogleService googleService;

    @Autowired
    public GoogleController(GoogleService googleService) {
        this.googleService = googleService;
    }

    @GetMapping("/google")
    public Mono<String> getGoogle() {
        return googleService.get().onErrorReturn("Hello!");
    }
}
