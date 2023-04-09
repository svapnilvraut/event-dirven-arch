package com.event.driven.micro.services.twitter.to.kafka.service.runner.impl;

import com.event.driven.micro.services.twitter.to.kafka.service.config.TwitterToKafkaServiceConfig;
import com.event.driven.micro.services.twitter.to.kafka.service.listener.TwitterKafkaStatusListener;
import com.event.driven.micro.services.twitter.to.kafka.service.runner.StreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class MockKafkaStreamRunner implements StreamRunner {

    private final TwitterToKafkaServiceConfig config;
    private final TwitterKafkaStatusListener statusListener;

    private static final Random RANDOM = new Random();
    private static final String[] WORDS = new String[] {
            "tristique",
            "sollicitudin",
            "nibh",
            "sit",
            "amet",
            "commodo",
            "nulla",
            "facilisi",
            "nullam",
            "vehicula",
            "ipsum",
            "a",
            "arcu",
            "cursus",
            "vitae",
            "congue",
            "mauris",
            "rhoncus",
            "aenean",
            "vel",
            "elit",
            "scelerisque",
            "mauris",
            "pellentesque",
            "pulvinar",
            "pellentesque",
            "habitant",
            "morbi",
            "tristique",
            "senectus"
    };

    private static final String tweetAsRawJson = "{\"created_at\": \"{0}\", " +
            "\"id\": \"{1}\", " +
            "\"text\": \"{2}\", " +
            "\"user\": {\"id\": \"{3}\"}" +
            "}";

    private static final String TWITTER_STATUS_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
    @Override
    public void start() throws TwitterException {

    }
}
