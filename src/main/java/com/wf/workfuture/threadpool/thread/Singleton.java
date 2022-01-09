package com.wf.workfuture.threadpool.thread;

/**
 * Created by wangfeng 23:09 2020/11/5
 **/
public class Singleton {

    private Singleton() {
    }

    private static class SingletonHolder {

        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}

