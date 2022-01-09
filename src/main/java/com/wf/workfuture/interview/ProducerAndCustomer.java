package com.wf.workfuture.interview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by wangfeng 20:17 2020/11/16
 **/


public class ProducerAndCustomer {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread producer1 = new Thread(new Producer(resource));
        Thread producer2 = new Thread(new Producer(resource));
        producer1.start();
        producer2.start();

        Thread customer1 = new Thread(new Customer(resource));
        Thread customer2 = new Thread(new Customer(resource));
        Thread customer3 = new Thread(new Customer(resource));
        customer1.start();
        customer2.start();
        customer3.start();
    }
}

class Resource {

    private Queue<String> resource = new ArrayDeque<>();
//    private boolean empty = true;

    synchronized public void push(String data){

        try {
            while(resource.size() >= 10) {
                this.wait();
            }
            resource.offer(data);
            System.out.println("product: " + data);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void pop(){

        try {
            while(resource.isEmpty()) {
                this.wait();
            }
            String data = resource.poll();
            System.out.println("eat: " + data);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{

    private Resource resource = null;

    public Producer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run(){
        for (int i = 1; i <= 200; i++) {
            String str = "苹果: ";
            resource.push(str + i);
        }
    }

}

class Customer implements Runnable{

    private Resource resource = null;

    public Customer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run(){
        for (int i = 1; i <= 200; i++) {
            resource.pop();
        }
    }
}