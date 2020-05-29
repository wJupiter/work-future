package com.wf.workfuture.interview;

import java.util.Scanner;

/**
 * Created by wangfeng 21:42 2020/5/29
 * 求解A/B=？
 * 描述:默认A是一个非常大的正整数，B也一个正整数，但大小随机，可大可小。
 * 注意:不能用正常的除法求解，也不需要使用位运算
 **/
public class DivisorDemo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Integer A = input.nextInt();
        Integer B = input.nextInt();
        System.out.println(getADivisorB(A, B));
    }

    /**
     * 使用二分法求解A/B，非常规解法，目前没有正确思路
     * @param a
     * @param b
     * @return Integer result =  A/B
     */
    public static Integer getADivisorB(Integer a, Integer b){
        if(a > Integer.MAX_VALUE) {
            throw new RuntimeException("a out of range at Integer");
        }
        Integer result = 0;
        Integer min = 1, max = a, mid = min + (max - min)/2;
        while (min < max) {
            if(a == mid * b) {
                return mid;
            } else if(a < mid * b) {
                min = mid + 1;
            } else {
                min = mid - 1;
            }
        }
        return result;
    }
}
