package com.event.driven.micro.services.twitter.to.kafka.service;

import com.event.driven.micro.services.twitter.to.kafka.service.config.TwitterToKafkaServiceConfig;
import com.event.driven.micro.services.twitter.to.kafka.service.runner.StreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class TwitterToKafkaService implements CommandLineRunner{

    private final TwitterToKafkaServiceConfig config;
    private final StreamRunner streamRunner;

    public static void main(String[] args) {
        log.info("Starting Twitter To Kafka Micro service");
        SpringApplication.run(TwitterToKafkaService.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application starts...");
        log.info(Arrays.toString(config.getTwitterKeywords().toArray(new String[0])));
        streamRunner.start();
    }
}