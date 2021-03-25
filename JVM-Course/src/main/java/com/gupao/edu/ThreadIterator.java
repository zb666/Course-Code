package com.gupao.edu;

import java.util.List;

public class ThreadIterator extends Thread{


    private List list;

    public ThreadIterator(List list){
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            for (Object o : list) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
