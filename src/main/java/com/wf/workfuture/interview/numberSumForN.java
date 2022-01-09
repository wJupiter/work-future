package com.wf.workfuture.interview;

/**
 * Created by wangfeng 22:43 2020/11/13
 *
 * **
 *     数字n
 *     求 多少种连续的数之和为n的个数
 *
 *     n=9
 *         9 = 2+3+4
 *         9 = 4+5
 *
 *         9 = 1+8
 *
 *     输出 2
 *
 *     公式 S=(x+y)(y-x+1)/2
 *         **/
public class numberSumForN {

    public int funtion(int n){
        int sum = 0;
        int count = 0;
        for (int i = 1; i < n; i++ ){
            sum = i;
            for (int j = i + 1; j < n; j++){
                sum+=j;
                if(sum == n){
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
        return count;
    }
}
