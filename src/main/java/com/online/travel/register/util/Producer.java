package com.online.travel.register.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.travel.register.entity.Hotel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableConfigurationProperties
public class Producer {

    @Value("${topic.name}")
    private String hotelTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(Hotel hotel) throws JsonProcessingException {
        String hotelAsMessage = objectMapper.writeValueAsString(hotel);
        kafkaTemplate.send(hotelTopic, hotelAsMessage);

        log.info("hotel message produced {}", hotelAsMessage);

        return "message sent";
    }
}
