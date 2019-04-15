package com.poc.nonreactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleController {

    private final GoogleService googleService;

    public GoogleController(GoogleService googleService) {
        this.googleService = googleService;
    }

    @GetMapping("/google")
    public String getGoogle() {
        return googleService.get();
    }
}
