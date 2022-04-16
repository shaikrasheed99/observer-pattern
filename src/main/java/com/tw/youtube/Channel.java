package com.tw.youtube;

import com.tw.IPublisher;
import com.tw.ISubscriber;

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

    public void upload(Video video) {
        videos.add(video);
        sendNotifications();
    }
}
