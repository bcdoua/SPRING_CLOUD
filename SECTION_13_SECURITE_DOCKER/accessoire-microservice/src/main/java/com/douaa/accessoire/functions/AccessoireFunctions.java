package com.douaa.accessoire.functions;

import com.douaa.accessoire.service.AccessoireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AccessoireFunctions {

    private static final Logger log = LoggerFactory.getLogger(AccessoireFunctions.class);

    @Bean
    public Consumer<Long> updateCommunication(AccessoireService accessoireService) {
        return accessoireId -> {
            log.info("Updating Communication status for the accessoire Id : " + accessoireId.toString());
            accessoireService.updateCommunicationStatus(accessoireId);
        };
    }
}