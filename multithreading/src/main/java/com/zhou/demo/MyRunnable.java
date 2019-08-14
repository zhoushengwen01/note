package com.zhou.demo;

public class MyRunnable implements Runnable{

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("hahaha");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
