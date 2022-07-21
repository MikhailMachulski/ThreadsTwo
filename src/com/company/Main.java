package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> myCallable = new MyCallable();
        Callable<Integer> myCallable1 = new MyCallable();
        Callable<Integer> myCallable2 = new MyCallable();
        Callable<Integer> myCallable3 = new MyCallable();

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer> task = threadPool.submit(myCallable);
        Future<Integer> task1 = threadPool.submit(myCallable1);
        Future<Integer> task2 = threadPool.submit(myCallable2);
        Future<Integer> task3 = threadPool.submit(myCallable3);

        List<Callable<Integer>> list = new ArrayList<>();

        list.add(myCallable);
        list.add(myCallable1);
        list.add(myCallable2);
        list.add(myCallable3);

        threadPool.invokeAll(list);

        final int result = task.get();
        final int result1 = task1.get();
        final int result2 = task2.get();
        final int result3 = task3.get();

        System.out.println(result + " " + result1 + " " + result2 + " " + result3);

        System.out.println(threadPool.invokeAny(list));

        threadPool.shutdown();
    }
}
