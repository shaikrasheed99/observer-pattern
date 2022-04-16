package com.tw.newsletter;

public class PoliticalLeader implements ISubscriber {
    @Override
    public void notification() {
        System.out.println("Political Leader got received his notification!");
    }
}
