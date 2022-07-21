package com.company;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2500);
            System.out.println("Thread " + Thread.currentThread().getName() + ". Всем привет!");
            count ++;
        }
        return count;
    }
}
