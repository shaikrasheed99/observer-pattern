package com.tw.newsletter;

public class SoftwareDeveloper implements ISubscriber {
    @Override
    public void notification() {
        System.out.println("Software Developer got received his notification!");
    }
}
