//package com.wf.workfuture.interview;
//
//import java.math.BigInteger;
//import java.util.Scanner;
//
///**
// * Created by wangfeng 20:17 2020/12/2
// **/
//public class Main {
//
//
//    /**
//     * 2. 两个大数相加，输入两个字符串数字，返回一个字符串数字。
//     */
//
//    public String BigNumberAdd(String a, String b) {
//
//        char[] ch1 = a.toCharArray();
//        char[] ch2 = b.toCharArray();
//        int i = ch1.length;
//        int j = ch2.length;
//        boolean carry = false;
//        StringBuilder sb = new StringBuilder();
//        while (i >= 0 && j >= 0) {
//            char num1 = ch1[i];
//            char num2 = ch2[j];
//            //相加
//            int sum = num1 - '0' + num2 - '0';
//            //判断上一次相加有没有进位
//            sum = carry ? sum + 1 : sum;
//            // 本次相加有没有进位
//            carry = sum >= 10 ? true : false;
//            // 相加结果 取个位数->字符类型
//            sb.append((char) ((sum % 10) + '0'));
//            i--;
//            j--;
//        }
//
//        //处理剩余的元素
//        while (carry || i >= 0 || j >= 0) {
//            if (i >= 0) {
//                //相加 + 判断进位
//                int sum = ch1[i] - '0' + (carry ? 1 : 0);
//                // 本次相加有没有进位
//                carry = sum >= 10 ? true : false;
//                // 添加到结果
//                sb.append((char) ((sum % 10) + '0'));
//                i--;
//            } else if (j >= 0) {
//                //相加 + 判断进位
//                int sum = ch2[j] - '0' + (carry ? 1 : 0);
//                //本次相加有没有进位
//                carry = sum > 10 ? true : false;
//                //添加到结果
//                sb.append((char) ((sum % 10) + '0'));
//                j--;
//            }
//        }
//        return sb.reverse().toString();
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        Integer n = input.nextInt();
//        System.out.println(fibonaqi(n));
//    }
//
//    /**
//     * 1. 求斐波那契数列第n个数。
//     */
//    public static String fibonaqi(int n){
//
//        if(n == 1 || n == 2) {
//            return "1";
//        }
//        BigInteger[] array = new BigInteger[n];
//        array[0] = new BigInteger("1");
//        array[1] = new BigInteger("2");
//        for (int i = 2; i < n; i++) {
//            array[i] = array[i-1].add(array[i-2]);
//        }
//        return array[n-1].toString();
//    }
//
//    public class Solution {
//        public int atoi(String str) {
//            if(str == null || str.length() == 0){
//                return 0;
//            }
//
//            int len = str.length();
//            int temp = 0;
//            try{
//                for(int i = 0; i < len; i++){
//                    int ch = str.charAt(i) - '0';
//                    temp += temp * 10 + ch;
//                    //判断是否是数字字符
//                    if(ch)
//
//                        if(Integer.MAX_VALUE - temp < (str.charAt(i) - '0') * Math.pow(10, (len - i - 1))){
//                        throws new RuntimeException(", ");
//                        }
//                    temp += (str.charAt(i) - '0') * Math.pow(10, (len - i - 1));
//
//
//                }
//            } catch(RuntimeException e){
//            throws new RuntimeException(", ");
//            }
//            return temp;
//        }
//    }
//
//}
