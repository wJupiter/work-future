package com.wf.workfuture.interview;

/**
 * Created by wangfeng 20:29 2020/12/28
 **/
public class SIngleton {

    private static volatile SIngleton INSTANCE = null;

    private SIngleton() {

    }

//    private static class SingletonHolder {
//       private static SIngleton INSTANCE = new SIngleton();
//    }

    public static SIngleton getInstance() {
        if(INSTANCE == null){
            synchronized (SIngleton.class){
                if(INSTANCE == null){
                    INSTANCE = new SIngleton();
                }
            }
        }
        return INSTANCE;
    }

}


