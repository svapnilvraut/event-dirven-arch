package com.event.driven.micro.services.twitter.to.kafka.service.runner.impl;

import com.event.driven.micro.services.twitter.to.kafka.service.config.TwitterToKafkaServiceConfig;
import com.event.driven.micro.services.twitter.to.kafka.service.listener.TwitterKafkaStatusListener;
import com.event.driven.micro.services.twitter.to.kafka.service.runner.StreamRunner;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.v1.FilterQuery;
import twitter4j.v1.TwitterStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class TwitterKafkaStreamRunner implements StreamRunner {

    private final TwitterToKafkaServiceConfig config;
    private final TwitterKafkaStatusListener statusListener;

    private TwitterStream twitterStream;
    @Override
    public void start() throws TwitterException {
        String[] keywords = config.getTwitterKeywords().toArray(new String[0]);
        FilterQuery filterQuery = FilterQuery.ofTrack(keywords);
        twitterStream = Twitter.newBuilder()
                .listener(statusListener)
                .build()
                .v1().stream();
        twitterStream.filter(filterQuery);
    }

    @PreDestroy
    public void shutDown(){
        if (twitterStream != null) {
            log.info("Closing twitter stream");
            twitterStream.shutdown();
        }
    }
}
