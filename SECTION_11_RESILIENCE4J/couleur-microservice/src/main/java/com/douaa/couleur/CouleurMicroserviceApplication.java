package com.douaa.couleur;

import com.douaa.couleur.entities.Couleur;
import com.douaa.couleur.repos.CouleurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CouleurMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouleurMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CouleurRepository couleurRepository) {
        return args -> {
            couleurRepository.save(Couleur.builder()
                    .couleurName("Rouge")
                    .couleurCode("RD")
                    .build());
            couleurRepository.save(Couleur.builder()
                    .couleurName("Bleu")
                    .couleurCode("BL")
                    .build());
        };
    }
}