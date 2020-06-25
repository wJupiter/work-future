package com.wf.workfuture.algorithmPractise.jianzhiOffer;

import java.util.Scanner;

/**
 * Created by wangfeng 17:40 2020/6/24
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question_64 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
//            System.out.println(sumNums(n));
            System.out.println(Sum_Solution(n));
        }
    }

    public static int sumNums(int n) {

        int sum;
        sum = n * (n + 1) >> 1;
        return sum;
    }

    /**
     * 短路与替代
     * @param n
     * @return
     */
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean result = (n > 0) && (( sum += Sum_Solution (n - 1 )) > 0);
        return sum;
    }


    public static int Sum_Solution_old(int n) {
        int sum = n;
        if(n < 0){
            return 0;
        }
        else {
            sum += Sum_Solution(n - 1);
        }
        return sum;
    }
}
