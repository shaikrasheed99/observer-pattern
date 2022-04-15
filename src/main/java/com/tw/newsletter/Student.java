package com.tw.newsletter;

public class Student implements ISubscriber {
    @Override
    public void notification() {
        System.out.println("Student got received his notification!");
    }
}
