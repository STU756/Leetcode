package com.jia;

import java.util.concurrent.LinkedBlockingQueue;

class Request {
    private String name;

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface RequestProcessor {
    void processRequest(Request request);
}

class PrintProcessor extends Thread implements
        RequestProcessor {
    LinkedBlockingQueue<Request> requests = new
            LinkedBlockingQueue<Request>();
    private final RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request request = requests.take();
                System.out.println("print data:" + request.getName());
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //处理请求
    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}

class SaveProcessor extends Thread implements
        RequestProcessor {
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();
    @Override
    public void run() {
        while (true) {
            try {
                Request request = requests.take();
                System.out.println("begin save request info:" + request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //处理请求
    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}

public class Demo {
    PrintProcessor printProcessor;

    protected Demo() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    private void doTest(Request request) {
        printProcessor.processRequest(request);
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("Mic");
        new Demo().doTest(request);
    }
}