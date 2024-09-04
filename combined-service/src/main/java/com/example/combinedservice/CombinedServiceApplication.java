package com.example.combinedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@RestController
public class CombinedServiceApplication {

    private final WebClient.Builder webClientBuilder;

    public CombinedServiceApplication(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }
    public static void main(String[] args) {
        SpringApplication.run(CombinedServiceApplication.class, args);
    }

    @GetMapping("/combined")
    public String getCombinedMessage() {
        String hello = webClientBuilder.build()
                .get()
                .uri("http://127.0.0.1:58893/hello")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        String world = webClientBuilder.build()
                .get()
                .uri("http://127.0.0.1:58928/world")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return hello + " " + world;
    }
}
