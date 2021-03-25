package com.example.rocketmq;

public class GCTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<100;i++){
            GCTest gcTest = new GCTest();
            System.gc();
        }

        Thread.sleep(5000);
    }

}
