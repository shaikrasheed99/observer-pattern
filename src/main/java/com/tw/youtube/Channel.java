package com.tw.youtube;

import com.tw.IPublisher;
import com.tw.ISubscriber;
import com.tw.exceptions.SubscriberAlreadyExist;
import com.tw.exceptions.SubscriberDoesNotExist;

import java.util.ArrayList;
import java.util.List;

public class Channel implements IPublisher {

    private final List<ISubscriber> subscribers;
    private final List<Video> videos;

    public Channel() {
        this.subscribers = new ArrayList<>();
        this.videos = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) throws SubscriberAlreadyExist {
        if (isExist(subscriber)) throw new SubscriberAlreadyExist();
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) throws SubscriberDoesNotExist {
        if (!isExist(subscriber)) throw new SubscriberDoesNotExist();
        subscribers.remove(subscriber);
    }

    @Override
    public void sendNotifications() {
        subscribers.forEach(ISubscriber::notification);
    }

    public void upload(Video video) {
        videos.add(video);
        sendNotifications();
    }

    private boolean isExist(ISubscriber subscriber) {
        return subscribers.contains(subscriber);
    }
}
