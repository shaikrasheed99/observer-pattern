package com.tw.newsletter;

public interface IPublisher {
    void subscribe(ISubscriber observer);
    void unsubscribe(ISubscriber observer);
    void sendNotifications();
}
