package com.tw.newsletter;

import com.tw.newsletter.exceptions.SubscriberAlreadyExist;
import com.tw.newsletter.exceptions.SubscriberDoesNotExist;

public interface IPublisher {
    void subscribe(ISubscriber subscriber) throws SubscriberAlreadyExist;

    void unsubscribe(ISubscriber subscriber) throws SubscriberDoesNotExist;

    void sendNotifications();
}
