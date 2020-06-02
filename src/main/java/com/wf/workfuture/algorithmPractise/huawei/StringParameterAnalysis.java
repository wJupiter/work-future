package com.wf.workfuture.algorithmPractise.huawei;

import java.util.ArrayList;
import java.util.Scanner;
import sun.tools.jstat.Scale;

/**
 * Created by wangfeng 10:47 2020/6/2 字符串解析
 **/
public class StringParameterAnalysis {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String param;
        while (input.hasNext()) {
            param = input.nextLine();
            stringAnalyze(param);
        }
    }

    private static void stringAnalyze(String params) {

        int len = params.length();
        //临时存储单个参数的变量
        ArrayList<Character> param = new ArrayList<>(32);
        ArrayList<String> paramList = new ArrayList(8);

        int i = 0;
        while (i < len){
            param.add(params.charAt(i++));
            //按空格拆分字符串
            if (params.charAt(i) == ' ' || i == len) {
                String str = String.valueOf(param);
                System.out.println("1、param:" + param.toString() + "====");
                paramList.add(str);
                param.clear();
            }
            //规避空格
            i++;
            //拆分双引号中的字符串
            if (params.charAt(i) == '\"') {
                //规避双引号
                i++;
                char inchar = params.charAt(i);
                while (inchar != '\"') {
                    param.add(inchar);
                    i++;
                }
                paramList.add(String.valueOf(param));
                System.out.println("2、param:" + param.toString() + "====");
            }
        }

        System.out.println(paramList.size());
        for (String str: paramList) {
            System.out.println(str);
        }
    }
}
