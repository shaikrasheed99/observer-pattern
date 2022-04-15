package com.tw.newsletter;

import java.util.ArrayList;
import java.util.List;

public class NewsLetter implements IPublisher {
    private final List<ISubscriber> subscribers;

    public NewsLetter() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(ISubscriber observer) {
        subscribers.remove(observer);
    }

    @Override
    public void sendNotifications() {
        subscribers.forEach(ISubscriber::notification);
    }
}
