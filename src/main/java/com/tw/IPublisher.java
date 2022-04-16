package com.tw;

import com.tw.exceptions.SubscriberAlreadyExist;
import com.tw.exceptions.SubscriberDoesNotExist;

public interface IPublisher {
    void subscribe(ISubscriber subscriber) throws SubscriberAlreadyExist;

    void unsubscribe(ISubscriber subscriber) throws SubscriberDoesNotExist;

    void sendNotifications();
}
