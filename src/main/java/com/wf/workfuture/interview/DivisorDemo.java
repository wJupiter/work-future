package com.wf.workfuture.interview;

import java.util.Scanner;

/**
 * Created by wangfeng 21:42 2020/5/29 求解A/B=？ 描述:默认A是一个非常大的正整数，B也一个正整数，但大小随机，可大可小。
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
     * 使用二分法求解A/B，非常规解法。
     *
     * 假设 mid = (A + B) / 2
     *     B * mid == A
     *
     * if B * mid < A, 则 mid 属于 (mid, A]
     * if B * mid > A, 则 mid 属于 [B, mid)
     * 循环判断直到
     * @return Integer A/B
     */
    public static Integer getADivisorB(Integer a, Integer b) {
        if (a > Integer.MAX_VALUE || b > Integer.MAX_VALUE) {
            throw new RuntimeException("a:" + a + "or" + "b:"+ b + " out of range at Integer");
        }
        if(b == 1) {
            return a;
        }

//        Integer min = b, max = a;
        Integer min = 1, max = a;
//        Integer mid = (max + min) / 2;
        Integer mid = min + (max - min) / 2;

        while (b * mid != a) {
//            if(a - b * mid < b) {
//                return mid;
//            }
            if(b * mid < a) {
                // 处理b有余数的情况
                min = mid + 1;
                max = a;
            } else {
                min = b;
                max = mid -1;
            }
            mid = min + (max - min) / 2;
        }
        return mid;
    }
}
