package com.wf.workfuture.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangfeng 17:10 2020/6/9
 * new FixedThreadPool() 固定数量的线程池。
 **/
public class ThreadpoolDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(
                System.currentTimeMillis() + " :Thread ID: " + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        long start = System.currentTimeMillis();
        //1、固定数量的线程池，使用任务队列，不建议使用
//        ExecutorService es = Executors.newFixedThreadPool(5);
        //2、newCachedThreadPool()，该方法返回一个可根据实际情况调整线程使用数量的线程池。
        //3、new ScheduledThreadPool();
        ExecutorService es = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            es.submit(task);
        }
        long end = System.currentTimeMillis();
        System.out.println("mainThread: " + Thread.currentThread().getId() + ", timeout: " + (end - start));
    }

}
