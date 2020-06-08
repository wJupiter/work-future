package com.wf.workfuture.algorithmPractise.huawei;

import java.util.Scanner;

/**
 * Created by wangfeng 18:00 2020/6/6
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.nextLine();
            int start = input.nextInt();
            int end = input.nextInt();
            String strs = function(str, start, end);
            System.out.print(strs);
        }
    }

    private static String function(String str, int start, int end) {
        if(str == null || str.length() == 0) {
            return "EMPTY";
        }
        if(start < 0 || end > str.length() - 1){
            return "EMPTY";
        }

        String[] str1 = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length; i++){
            int tempIndex = end;
            while (i >= start && i <= end) {
                String temp = str1[i];
                sb.append(str1[tempIndex--]).append(" ");
                i++;
            }
            String temp = str1[i];
            sb.append(temp).append(" ");
        }
        sb.deleteCharAt(str.length());
        return sb.toString();
    }
}
