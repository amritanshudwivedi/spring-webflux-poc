package com.poc.slow;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Service
public class SlowService {
    Mono<String> get(int slowness) {
        return Mono.just("Hello!").delayElement(Duration.of(slowness, ChronoUnit.MILLIS));
    }
}
