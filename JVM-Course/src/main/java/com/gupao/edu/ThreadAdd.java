package com.gupao.edu;

import java.util.List;

public class ThreadAdd extends Thread {

    private List list;

    public ThreadAdd(List list){
        this.list = list;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            try {
                Thread.sleep(5);
                list.add(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
