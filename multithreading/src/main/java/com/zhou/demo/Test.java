package com.zhou.demo;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        String string = getString();
        System.out.println(string);

    }


    private static String getString(){
        MyRunnable myRunnable = new MyRunnable();
        Thread thread= new Thread(myRunnable);
        thread.start();
        return "Test";

    }
}
