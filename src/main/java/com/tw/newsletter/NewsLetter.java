package com.tw.newsletter;

import com.tw.newsletter.exceptions.SubscriberAlreadyExist;
import com.tw.newsletter.exceptions.SubscriberDoesNotExist;

import java.util.ArrayList;
import java.util.List;

public class NewsLetter implements IPublisher {
    private final List<ISubscriber> subscribers;

    public NewsLetter() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) throws SubscriberAlreadyExist {
        if (subscribers.contains(subscriber)) throw new SubscriberAlreadyExist();
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) throws SubscriberDoesNotExist {
        if (!subscribers.contains(subscriber)) throw new SubscriberDoesNotExist();
        subscribers.remove(subscriber);
    }

    @Override
    public void sendNotifications() {
        subscribers.forEach(ISubscriber::notification);
    }
}
