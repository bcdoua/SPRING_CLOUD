package com.douaa.accessoire;

import com.douaa.accessoire.entities.Accessoire;
import com.douaa.accessoire.repos.AccessoireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class AccessoireMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessoireMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccessoireRepository accessoireRepository) {
        return args -> {
            accessoireRepository.save(Accessoire.builder()
                    .accessoireName("Sac a main")
                    .accessoireCode("A001")
                    .couleurCode("RD")
                    .build());
            accessoireRepository.save(Accessoire.builder()
                    .accessoireName("Montre")
                    .accessoireCode("A002")
                    .couleurCode("RD")
                    .build());
            accessoireRepository.save(Accessoire.builder()
                    .accessoireName("Echarpe")
                    .accessoireCode("A003")
                    .couleurCode("BL")
                    .build());
        };
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}