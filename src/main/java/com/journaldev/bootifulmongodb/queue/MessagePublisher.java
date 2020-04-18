package com.journaldev.bootifulmongodb.queue;

/**
 * Created by sukeshgupta on 29/12/19.
 */
public interface MessagePublisher {
    void publish(final String message);
}
