package com.tw.newsletter;

import com.tw.newsletter.exceptions.SubscriberAlreadyExists;

public interface IPublisher {
    void subscribe(ISubscriber observer) throws SubscriberAlreadyExists;
    void unsubscribe(ISubscriber observer);
    void sendNotifications();
}
