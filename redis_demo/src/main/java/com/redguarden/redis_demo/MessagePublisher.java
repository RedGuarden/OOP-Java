package com.redguarden.redis_demo;

public interface MessagePublisher {
    void publish(final String message);
}
