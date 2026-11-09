package com.douaa.message.functions;

import com.douaa.message.dto.AccessoireMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<AccessoireMessageDto, AccessoireMessageDto> email() {
        return accessoireMsgDto -> {
            log.info("Sending email with the details : " + accessoireMsgDto.toString());
            return accessoireMsgDto;
        };
    }

    @Bean
    public Function<AccessoireMessageDto, Long> sms() {
        return accessoireMsgDto -> {
            log.info("Sending sms with the details : " + accessoireMsgDto.toString());
            return accessoireMsgDto.accessoireId();
        };
    }
}