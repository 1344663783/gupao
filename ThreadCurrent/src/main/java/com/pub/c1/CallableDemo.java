package com.pub.c1;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableDemo callableDemo = new CallableDemo();

        Future<String> submit = executorService.submit(callableDemo);
        System.out.println(submit.get());
        executorService.shutdown();
    }
    public String call() throws Exception {
        return "callable";
    }
}
