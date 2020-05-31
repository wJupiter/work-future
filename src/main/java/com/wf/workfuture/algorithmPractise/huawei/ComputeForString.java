package com.wf.workfuture.algorithmPractise.huawei;

import java.util.Scanner;

/**
 * Created by wangfeng 15:26 2020/5/31
 * 表达式求值
 **/
public class ComputeForString {

    static char[] ch = {'+','-','*','/','0','1','2','3','4','5','6','7','8','9','(',')'};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.nextLine();
            Integer res = function(str);
            System.out.println(res);
        }
    }

    private static Integer function(String str) {
        //1、判断字符串是否合法
        //2、字符串中的字符逆序入栈
        //3、单独提取出数字和操作字符
        //4、依次进行加减操作。
        //5、返回最终结果
        return 0;
    }
}
