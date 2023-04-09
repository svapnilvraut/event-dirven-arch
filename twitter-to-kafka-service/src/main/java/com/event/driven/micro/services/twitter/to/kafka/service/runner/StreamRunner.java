package com.event.driven.micro.services.twitter.to.kafka.service.runner;

import twitter4j.TwitterException;

public interface StreamRunner {
    void start() throws TwitterException;
}
