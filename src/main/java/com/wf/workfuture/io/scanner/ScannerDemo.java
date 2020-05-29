package com.wf.workfuture.io.scanner;

import java.util.Scanner;

/**
 * Created by wangfeng 16:30 2020/5/9
 **/
public class ScannerDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        System.out.println("next方式接收：");

//        while (!scan.hasNext("!")){
//            String str = scan.next();
//            System.out.println("输入的数据为：" + str);
//        }
//        scan.close();

        System.out.println("nextLine方式接收：");

        while (!scan.hasNext("!")){
            String str = scan.nextLine();
            System.out.println("输入的数据为：" + str);
        }
        scan.close();

    }

}
