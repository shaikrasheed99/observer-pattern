package com.tw.newsletter;

import java.util.ArrayList;
import java.util.List;

public class NewsLetter implements IPublisher {
    private final List<ISubscriber> subscribers;

    public NewsLetter() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void sendNotifications() {
        subscribers.forEach(ISubscriber::notification);
    }
}
