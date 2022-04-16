package com.tw;

public class PoliticalLeader implements ISubscriber {
    @Override
    public void notification() {
        System.out.println("Political Leader got received his notification!");
    }
}
