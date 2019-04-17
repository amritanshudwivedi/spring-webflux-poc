package com.poc.slow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SlowController {

    private final SlowService slowService;

    public SlowController(SlowService slowService) {
        this.slowService = slowService;
    }

    @GetMapping("/slow/{slowness}")
    public Mono<String> slowMethod(@PathVariable(value = "slowness") int slowness) {
        return slowService.get(slowness);
    }
}
