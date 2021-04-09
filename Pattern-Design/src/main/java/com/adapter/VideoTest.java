package com.adapter;

public class VideoTest {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Phone());
        adapter.doPlay();
    }
}
