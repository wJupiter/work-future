package com.wf.workfuture.algorithmPractise;

import java.util.Scanner;

/**
 * Created by wangfeng 12:38 2020/5/31
 * 题目描述
 * 描述：
 *
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 *
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 复制
 * 1516000
 * 输出
 * 复制
 * 0006151
 *
 * 解答：将输入的int数字转为字符串，然后生成字符数据，逆序输出。
 **/
public class NumberReverse {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String str = String.valueOf(num);
        int length = str.length();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[length - i - 1]);
        }
    }
}
