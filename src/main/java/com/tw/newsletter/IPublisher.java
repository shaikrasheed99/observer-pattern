package com.tw.newsletter;

import com.tw.newsletter.exceptions.SubscriberAlreadyExist;
import com.tw.newsletter.exceptions.SubscriberDoesNotExist;

public interface IPublisher {
    void subscribe(ISubscriber observer) throws SubscriberAlreadyExist;
    void unsubscribe(ISubscriber observer) throws SubscriberDoesNotExist;
    void sendNotifications();
}
