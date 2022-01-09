package com.wf.workfuture.threadpool.thread;

/**
 * Created by wangfeng 20:49 2020/11/2
 **/
class Print {

    boolean flag = true;

    public synchronized void printA(int i) {
        while (!flag) {
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        flag = false;
        System.out.println(i + "---A");
        this.notify();
    }

    public synchronized void printB(int i) {
        while (flag) {
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        flag = true;
        System.out.println(i + "---B");
        this.notify();
    }
}

public class PrintAB {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        Print print = new Print();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    print.printA(i);
                }
            }
        });
        threadA.start();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    print.printB(i);
                }
            }
        });
        threadB.start();
    }
}
