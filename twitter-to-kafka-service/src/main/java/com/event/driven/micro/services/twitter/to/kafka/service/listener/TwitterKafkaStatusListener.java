package com.event.driven.micro.services.twitter.to.kafka.service.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import twitter4j.v1.Status;
import twitter4j.v1.StatusAdapter;

@Component
@Slf4j
public class TwitterKafkaStatusListener extends StatusAdapter {

    @Override
    public void onStatus(Status status) {
        log.info("Twitter status with text {}", status.getText());
        super.onStatus(status);
    }
}
