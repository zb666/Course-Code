package com.adapter;

public class Adapter implements VGAPlayer{

    //接受来自于Phone的信号，并且投影

    private Phone phone;

    public Adapter(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void doPlay() {
        phone.phonePlay();
        System.out.println("接受到了来自外界的信号，并且开始播放");
    }
}
