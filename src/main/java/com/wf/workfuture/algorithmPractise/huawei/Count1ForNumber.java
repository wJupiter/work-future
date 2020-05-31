package com.wf.workfuture.algorithmPractise.huawei;

import java.util.Scanner;

/**
 * Created by wangfeng 13:06 2020/5/31
 **/
public class Count1ForNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int number = input.nextInt();
            int count = function(number);
            System.out.println(count);
        }
    }

    /**
     * 统计十进制转为二进制后，1的个数
     * 1、该数对2取余
     * 2、统计余数为1的值
     * 3、该数对2去模
     * 4、如果该数大于0继续上述操作
     * @param number
     * @return
     */
    private static int function(int number) {
        if(number < 0 ) {
            return 0;
        }
        int count = 0;
        while (number > 0)  {
            int last = number % 2;
            if(last == 1) {
                ++count;
            }
            number = number / 2;
        }
        return count;
    }

}
