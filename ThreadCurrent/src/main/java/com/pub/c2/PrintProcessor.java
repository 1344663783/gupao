package com.pub.c2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class PrintProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue =  new LinkedBlockingQueue();

    private final RequestProcessor nextProcessor;

    public PrintProcessor( RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while (true){
            try {
                Request take = linkedBlockingQueue.take();
                System.out.println("print data:" + take);
                nextProcessor.processorRequest(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
