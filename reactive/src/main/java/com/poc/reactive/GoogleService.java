package com.poc.reactive;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class GoogleService {

    private final WebClient webClient;

    public GoogleService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://127.0.0.1:8001/slow").build();
    }

    @CircuitBreaker(name = "slow")
    public Mono<String> get() {
        return getInternal();
    }

    private Mono<String> getInternal() {
        Mono<String> stringMono1 = webClient.method(HttpMethod.GET).uri("/2000").retrieve().bodyToMono(String.class);
        Mono<String> stringMono2 = webClient.method(HttpMethod.GET).uri("/2000").retrieve().bodyToMono(String.class);
        Mono<String> stringMono3 = webClient.method(HttpMethod.GET).uri("/2000").retrieve().bodyToMono(String.class);
        return Mono.zip(stringMono1, stringMono2, stringMono3).map(t -> t.getT1() + t.getT2() + t.getT3());
    }
}