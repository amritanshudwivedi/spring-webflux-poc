package com.poc.nonreactive;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleService {


    private final RestTemplate restTemplate;

    public GoogleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    AsyncResult<ResponseEntity<String>> get(int slowness) {
        return new AsyncResult<ResponseEntity<String>>() {
            public ResponseEntity<String> invoke() {
                return restTemplate.getForEntity("http://127.0.0.1:8081/slow/1", String.class);
            }
        };

    }
}
