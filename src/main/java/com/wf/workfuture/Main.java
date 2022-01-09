package com.wf.workfuture;

import java.util.Scanner;

/**
 * Created by wangfeng 21:29 2020/9/16
 **/
public class Main {

    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String m = String.valueOf(n);
//        String result = reverse(m);
        Integer a = null;
        int b = 1;
        System.out.println(a == b);
    }

    private static String reverse(String str){
        if(str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            sb.append(str.charAt(len - 1 - i));
        }

        return sb.toString();
    }


}
