package com.wf.workfuture.algorithmPractise.huawei;

import java.util.Scanner;

/**
 * Created by wangfeng 15:05 2020/5/31
 **/
public class ReverseString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.nextLine();
            String strs = function(str);
            System.out.print(strs);
        }
    }

    /**
     * 字符串逆序
     *   判空
     * 1、string loop len-1 -> 1
     * 2、ch += str[i];
     * 3、return ch[len-1];
     * @param str
     * @return
     */
    private static String function(String str) {
        if(str == null || str.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            sb.append(str.charAt(len - i - 1));
        }
        return sb.toString();
    }
}
